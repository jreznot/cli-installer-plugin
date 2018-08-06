/*
 * Copyright (c) 2008-2018 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.cli.installer.addplugin

import com.beust.jcommander.Parameters
import com.haulmont.cli.installer.addplugin.dsl.CustomPrompts
import com.haulmont.cuba.cli.commands.AbstractCommand
import com.haulmont.cuba.cli.commands.CommonParameters
import com.haulmont.cuba.cli.green
import com.haulmont.cuba.cli.kodein
import com.haulmont.cuba.cli.localMessages
import com.haulmont.cuba.cli.prompting.QuestionsList
import org.kodein.di.generic.instance
import java.io.PrintWriter
import java.net.MalformedURLException
import java.net.URL

@Parameters(commandDescription = "Installs plugins for CLI")
class AddPluginCommand : AbstractCommand() {
    private val writer: PrintWriter by kodein.instance()

    private val messages by localMessages()

    private fun QuestionsList.prompting() {
        question("pluginJarUrl", "URL of plugin JAR file") {
            validate {
                value.isNotBlank() || fail("URL is required")

                try {
                    URL(value)
                } catch (e: MalformedURLException) {
                    fail("Incorrect URL")
                }
            }
        }
    }

    override fun run() {
        val questions = QuestionsList { prompting() }
        val answers = if (CommonParameters.nonInteractive.isEmpty()) {
            CustomPrompts(questions).ask()
        } else {
            CustomPrompts(questions).askNonInteractive()
        }

        writer.println("Downloading JAR file: ")

        // download JAR from the Internet

        // copy into ~/.haulmont/cli/plugins

        val pluginLocation = ""
        writer.println("Plugin installed into: $pluginLocation".green())
    }
}