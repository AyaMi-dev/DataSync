package kr.awr.kdv.ls.configuration

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.entity.EntityType
import org.bukkit.Bukkit
import org.bukkit.entity.Player

enum class ServerType {
    ITEM,
    BLOCK,
    ENTITY,
    PLAYER,
    BLOCK_ENTITY,
    MOB
}

class ServerTypeInfo {

    fun handleServerType(type: ServerType, customValue: Any?) {
        // ServerType에 따라 필요한 Bukkit 필드로 전송
        when (type) {
            ServerType.ITEM -> if (customValue is ItemStack) {
                Bukkit.getServer().broadcastMessage("아이템 전송됨: ${customValue.type}")
            } else {
                Bukkit.getServer().broadcastMessage("아이템 데이터가 잘못되었습니다.")
            }

            ServerType.BLOCK -> if (customValue is Material) {
                Bukkit.getServer().broadcastMessage("블록 전송됨: ${customValue.name}")
            } else {
                Bukkit.getServer().broadcastMessage("블록 데이터가 잘못되었습니다.")
            }

            ServerType.ENTITY, ServerType.MOB -> if (customValue is EntityType) {
                Bukkit.getServer().broadcastMessage("엔티티 전송됨: ${customValue.name}")
            } else {
                Bukkit.getServer().broadcastMessage("엔티티 데이터가 잘못되었습니다.")
            }

            ServerType.PLAYER -> if (customValue is String) {
                Bukkit.getServer().broadcastMessage("플레이어 전송됨: $customValue")
            } else {
                Bukkit.getServer().broadcastMessage("플레이어 데이터가 잘못되었습니다.")
            }

            ServerType.BLOCK_ENTITY -> Bukkit.getServer().broadcastMessage("블록 엔티티 전송이 필요합니다.")
        }
    }
}

