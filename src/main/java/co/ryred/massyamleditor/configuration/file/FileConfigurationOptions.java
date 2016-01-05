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

package co.ryred.massyamleditor.configuration.file;

import co.ryred.massyamleditor.configuration.MemoryConfiguration;
import co.ryred.massyamleditor.configuration.MemoryConfigurationOptions;

/**
 * Various settings for controlling the input and output of a {@link
 * FileConfiguration}
 */
public class FileConfigurationOptions extends MemoryConfigurationOptions {
    private String header = null;
    private boolean copyHeader = true;

    protected FileConfigurationOptions(MemoryConfiguration configuration) {
        super(configuration);
    }

    @Override
    public FileConfiguration configuration() {
        return (FileConfiguration) super.configuration();
    }

    @Override
    public FileConfigurationOptions pathSeparator(char value) {
        super.pathSeparator(value);
        return this;
    }

    @Override
    public FileConfigurationOptions copyDefaults(boolean value) {
        super.copyDefaults(value);
        return this;
    }

    /**
     * Gets the header that will be applied to the top of the saved output.
     * <p>
     * This header will be commented out and applied directly at the top of
     * the generated output of the {@link FileConfiguration}. It is not
     * required to include a newline at the end of the header as it will
     * automatically be applied, but you may include one if you wish for extra
     * spacing.
     * <p>
     * Null is a valid value which will indicate that no header is to be
     * applied. The default value is null.
     *
     * @return Header
     */
    public String header() {
        return header;
    }

    /**
     * Sets the header that will be applied to the top of the saved output.
     * <p>
     * This header will be commented out and applied directly at the top of
     * the generated output of the {@link FileConfiguration}. It is not
     * required to include a newline at the end of the header as it will
     * automatically be applied, but you may include one if you wish for extra
     * spacing.
     * <p>
     * Null is a valid value which will indicate that no header is to be
     * applied.
     *
     * @param value New header
     * @return This object, for chaining
     */
    public FileConfigurationOptions header(String value) {
        this.header = value;
        return this;
    }

    /**
     * Gets whether or not the header should be copied from a default source.
     * <p>
     * If this is true, if a default {@link FileConfiguration} is passed to
     * then upon saving it will use the header from that config, instead of
     * the one provided here.
     * <p>
     * If no default is set on the configuration, or the default is not of
     * type FileConfiguration, or that config has no header ({@link #header()}
     * returns null) then the header specified in this configuration will be
     * used.
     * <p>
     * Defaults to true.
     *
     * @return Whether or not to copy the header
     */
    public boolean copyHeader() {
        return copyHeader;
    }

    /**
     * Sets whether or not the header should be copied from a default source.
     * <p>
     * If this is true, if a default {@link FileConfiguration} is passed to
     * then upon saving it will use the header from that config, instead of
     * the one provided here.
     * <p>
     * If no default is set on the configuration, or the default is not of
     * type FileConfiguration, or that config has no header ({@link #header()}
     * returns null) then the header specified in this configuration will be
     * used.
     * <p>
     * Defaults to true.
     *
     * @param value Whether or not to copy the header
     * @return This object, for chaining
     */
    public FileConfigurationOptions copyHeader(boolean value) {
        copyHeader = value;

        return this;
    }
}
