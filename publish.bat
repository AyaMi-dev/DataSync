@echo off

:: GitHub 토큰과 리포지토리 URL 설정
set "GITHUB_TOKEN=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"
set "REPO_URL=https://%GITHUB_TOKEN%@github.com/AyaKanaKR/DataSync.git"


git init

:: 원격 origin 제거 시 오류가 발생해도 무시
git remote remove origin 2>nul

git remote add origin %REPO_URL%

:: 변경 사항 추가
git add .
git push --force origin master
git add origin %REPO_URL%

git reset -- .kotlin .idea .gradle


:: 커밋을 시도하고 실패 시 무시
git commit -m "Automated commit and push by gitPublish task" || echo "Nothing to commit, skipping push."

:: 쓰기 권한 오류 발생 시 메시지 출력
git push origin master || echo "Push failed, check your permissions."
