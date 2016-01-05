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

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Cory Redmond on 05/01/2016.
 *
 * @author Cory Redmond <ace@ac3-servers.eu>
 */
public class Main {

    public static void main(String... args) {

        if (args.length < 2) {
            System.err.println("Please provide file and yaml paths.");
            System.err.println("java -jar changer.jar /path/to/userdata/ options.to.change");
            return;
        }

        String[] pathValue = args[1].split("=");
        String path = pathValue[0];
        String value = null;
        if (pathValue.length == 2 && !pathValue[1].isEmpty()) value = pathValue[1];

        File root = new File(args[0]);

        if (!root.isDirectory()) {
            System.err.println(args[0] + " is not a directory!");
            return;
        }

        File[] editFiles = getYamlFiles(root);

        for (File file : editFiles) {

            try {
                CustomConfig cc = new CustomConfig(file);
                cc.getCustomConfig().set(path, value);
                cc.saveCustomConfig();
                System.out.println("Successfully transformed " + file.getName());
            } catch (Exception ex) {
                System.err.println("Unable to edit file: " + file.getName());
                System.err.println("   " + ex.getMessage());
            }

        }

    }

    public static File[] getYamlFiles(File dirFile) {
        return dirFile.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.toLowerCase().endsWith(".yml") || filename.toLowerCase().endsWith(".yaml");
            }
        });
    }

}
