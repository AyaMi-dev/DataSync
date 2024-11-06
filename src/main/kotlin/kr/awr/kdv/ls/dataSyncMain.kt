/*
 * Copyright    © 2024 AyaK_
 *
 * All rights reserved. This software, including but not limited to the code, design, and related assets, is the intellectual property of AyaK_. Unauthorized duplication, modification, distribution, or use of this software without explicit permission from AyaK_ is strictly prohibited.
 *
 * This software is not affiliated with Mojang Studios, Microsoft, or Minecraft. All Minecraft assets, including names and logos, are property of Mojang Studios. This project is intended for educational and personal use only.
 *
 * Any inquiries regarding permissions and usage rights should be directed to AyaK_.
 *
 */

package kr.awr.kdv.ls

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent
import com.velocitypowered.api.plugin.Plugin
import org.slf4j.Logger




@Plugin(
    id = "datasync",
    name = "DataSync",
    version = BuildConstants.VERSION,
    description = "Sharing data between servers",
    url = "https://github.com/AyaKanaKR/DataSync",
    authors = ["AyaK_"]
)


class dataSyncMain @Inject constructor(val logger: Logger) {

    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) {
        logger.info("================================")
        logger.info("Plugin DataSync has been initialized. Version: " + BuildConstants.VERSION)
        logger.info("Author: AyaK_")
        logger.info("GitHub: https://github.com/AyaKanaKR/DataSync")
        logger.info("Description: Sharing data between servers")
        logger.info("================================")

    }


    @Subscribe
    fun shutdown(event: ProxyShutdownEvent) {
        logger.info("================================")
        logger.info("Plugin DataSync has been shut down.")
        logger.info("================================")
    }
}
