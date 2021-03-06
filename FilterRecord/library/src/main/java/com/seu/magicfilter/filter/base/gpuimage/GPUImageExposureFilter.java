/*
 * Copyright (C) 2012 CyberAgent
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
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.seu.magicfilter.filter.base.gpuimage;

import android.opengl.GLES20;

import com.seu.magicfilter.R;

/**
 * exposure: The adjusted exposure (-10.0 - 10.0, with 0.0 as the default)
 */
public class GPUImageExposureFilter extends GPUImageFilter {

    private int mExposureLocation;
    private float mExposure;

    public GPUImageExposureFilter() {
        this(0.0f);
    }

    public GPUImageExposureFilter(final float exposure) {
        super(R.raw.exposure);
        mExposure = exposure;
    }

    @Override
    public void onInit() {
        super.onInit();
        mExposureLocation = GLES20.glGetUniformLocation(getProgram(), "exposure");
    }

    @Override
    public void onInitialized() {
        super.onInitialized();
        setExposure(mExposure);
    }

    public void setExposure(final float exposure) {
        mExposure = exposure;
        setFloat(mExposureLocation, mExposure);
    }
}
