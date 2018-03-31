package com.shhatrat.boilerplate_kkmvp

import com.shhatrat.boilerplate_kkmvp.di.Modules
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.Koin
import org.koin.log.PrintLogger
import org.koin.standalone.StandAloneContext
import org.koin.test.KoinTest
import org.koin.test.dryRun

/**
 * Created by szymon on 31/12/17.
 */
class DryRunTest : KoinTest {

    @Before
    fun before() {
        Koin.logger = PrintLogger()
    }

    @After
    fun after() {
        StandAloneContext.closeKoin()
    }

    private fun defaultProperties() = mapOf<String,String>()

    @Test
    fun normalConfiguration() {
        StandAloneContext.startKoin(Modules.get(), properties = defaultProperties())
        dryRun()
    }
}