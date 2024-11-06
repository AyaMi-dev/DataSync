@echo off

:: GitHub 토큰과 리포지토리 URL 설정
set "GITHUB_TOKEN=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"
set "REPO_URL=https://%GITHUB_TOKEN%@github.com/AyaKanaKR/DataSync.git"

:: Git 초기화
git init

:: 기존 원격 origin 제거 (오류 무시)
git remote remove origin 2>nul

:: 새로운 원격 origin 추가
git remote add origin %REPO_URL%

:: 커밋 제외할 파일들 리셋
git reset -- .kotlin .idea .gradle

:: 변경 사항 추가 및 커밋
git add .
git commit -m "Automated commit and push by gitPublish task" || echo "Nothing to commit, skipping push."

:: 푸시 시도 (오류 메시지 표시)
git push --force origin master || echo "Push failed, check your permissions."
