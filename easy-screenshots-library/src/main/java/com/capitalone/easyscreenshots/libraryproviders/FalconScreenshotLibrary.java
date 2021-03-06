/**
 * SPDX-Copyright: Copyright (c) Capital One Services, LLC
 * SPDX-License-Identifier: Apache-2.0
 * Copyright 2017 Capital One Services, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.capitalone.easyscreenshots.libraryproviders;

import com.capitalone.easyscreenshots.EasyScreenshots;
import com.capitalone.easyscreenshots.utils.ESUtil;
import com.jraska.falcon.Falcon;

import java.io.File;


import static com.capitalone.easyscreenshots.EasyScreenshots.log;

public class FalconScreenshotLibrary implements ScreenshotLibrary {

    private static final String TAG = FalconScreenshotLibrary.class.getSimpleName();

    /**
     * Use Falcon
     **/
    public File takeScreenshot(String tag) {
        File screenshotFile = null;
        long startTime = System.currentTimeMillis();
        try {
            screenshotFile = EasyScreenshots.getScreenshotFile(tag);
            Falcon.takeScreenshot(ESUtil.getCurrentActivityInstance(), screenshotFile);
        } catch (Exception ex) {
            log(TAG, "Unable to take screenshot with " + getLabel(), ex);
        }
        double seconds = ((System.currentTimeMillis() - startTime) / 1000.0);
        log(TAG, getLabel() + ": " + seconds + " seconds");
        return screenshotFile;
    }

    public String getLabel() {
        return getClass().getSimpleName();
    }

}
