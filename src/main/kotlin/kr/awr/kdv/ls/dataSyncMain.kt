package kr.awr.kdv.ls;

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
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
    }
}
