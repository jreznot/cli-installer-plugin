# CUBA CLI Installer Plugin

<a href="http://www.apache.org/licenses/LICENSE-2.0"><img src="https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat" alt="license" title=""></a>


Simple plugin that adds `add-plugin` command to [CUBA CLI](https://github.com/cuba-platform/cuba-cli), allowing user to install plugins from URL.

Read about plugin development [here](https://github.com/cuba-platform/cuba-cli/wiki/Plugin-Development).

## Installation

1. Copy .jar file into `~/.haulmont/cli/plugins/` directory.
1. Start `cuba-cli`

It will print loaded plugins:
```
cuba:~/$ cuba-cli 
Loaded plugin com.haulmont.cli.tutorial.PluginInstallerPlugin
```
