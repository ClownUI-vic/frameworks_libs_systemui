/*
 * Copyright (C) 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.app.tracing.coroutines

import android.platform.test.annotations.EnableFlags
import com.android.systemui.Flags.FLAG_COROUTINE_TRACING
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import org.junit.Before

@EnableFlags(FLAG_COROUTINE_TRACING)
open class TracingTestBase : TestBase() {

    protected lateinit var mainTraceContext: CoroutineContext

    @Before
    fun setupContexts() {
        mainTraceContext = createCoroutineTracingContext("main")
    }

    protected fun runTestTraced(block: suspend CoroutineScope.() -> Unit) {
        runTest(mainTraceContext, block)
    }
}