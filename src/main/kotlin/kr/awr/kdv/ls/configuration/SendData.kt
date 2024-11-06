/*
 * Copyright © 2024 AyaK_
 *
 * All rights reserved. This software, including but not limited to the code, design, and related assets, is the intellectual property of AyaK_. Unauthorized duplication, modification, distribution, or use of this software without explicit permission from AyaK_ is strictly prohibited.
 *
 * This software is not affiliated with Mojang Studios, Microsoft, or Minecraft. All Minecraft assets, including names and logos, are property of Mojang Studios. This project is intended for educational and personal use only.
 *
 * Any inquiries regarding permissions and usage rights should be directed to AyaK_.
 *
 */

package kr.awr.kdv.ls.configuration

interface SendData  {

    fun sendData(serverType: ServerType, data: Any)
    fun sendData(serverType: ServerType)
    fun sendData(data: Any)
    fun sendData()
    fun sendData(serverType: ServerType, data: Any, callback: () -> Unit)
    fun sendData(serverType: ServerType, callback: () -> Unit)
    fun sendData(data: Any, callback: () -> Unit)


}