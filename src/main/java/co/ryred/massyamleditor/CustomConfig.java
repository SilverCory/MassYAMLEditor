/*
 * http://ryred.co/
 * ace[at]ac3-servers.eu
 *
 * =================================================================
 *
 * Copyright (c) 2016, Cory Redmond
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 *  Neither the name of MYE nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package co.ryred.massyamleditor;

import co.ryred.massyamleditor.configuration.file.FileConfiguration;
import co.ryred.massyamleditor.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by Cory Redmond on 05/01/2016.
 *
 * @author Cory Redmond <ace@ac3-servers.eu>
 */
public class CustomConfig {

    private File customConfigFile;
    private YamlConfiguration customConfig;

    public CustomConfig(File file) {
        this.customConfigFile = file;
    }

    public void reloadCustomConfig() {
        this.customConfig = YamlConfiguration.loadConfiguration(this.customConfigFile);
        if (this.customConfig == null) {
            System.out.println("Couldn\'t find the file @ " + this.customConfigFile.getAbsolutePath());
        }
    }

    public FileConfiguration getCustomConfig() {
        if (this.customConfig == null) {
            this.reloadCustomConfig();
        }

        return this.customConfig;
    }

    public void saveCustomConfig() {
        if (this.customConfig != null && this.customConfigFile != null) {
            try {
                this.getCustomConfig().save(this.customConfigFile);
            } catch (IOException ioexception) {
                System.out.println("Could not save config to " + this.customConfigFile.getAbsolutePath());
            }

        }
    }
}