// Targeted by JavaCPP version 1.0-SNAPSHOT

package org.bytedeco.javacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_video.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import static org.bytedeco.javacpp.opencv_videoio.*;

public class opencv_superres extends org.bytedeco.javacpp.presets.opencv_superres {
    static { Loader.load(); }

// Parsed from <opencv2/superres.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_SUPERRES_HPP__
// #define __OPENCV_SUPERRES_HPP__

// #include "opencv2/core.hpp"
// #include "opencv2/superres/optical_flow.hpp"

/**
  @defgroup superres Super Resolution

The Super Resolution module contains a set of functions and classes that can be used to solve the
problem of resolution enhancement. There are a few methods implemented, most of them are descibed in
the papers @cite Farsiu03 and @cite Mitzel09 .

 */

/** @addtogroup superres
 *  @{ */

        @Namespace("cv::superres") public static class FrameSource extends Pointer {
            static { Loader.load(); }
            /** Empty constructor. */
            public FrameSource() { }
            /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
            public FrameSource(Pointer p) { super(p); }
        

            public native void nextFrame(@ByVal Mat frame);
            public native void reset();
        }

        @Namespace("cv::superres") public static native @Ptr FrameSource createFrameSource_Empty();

        @Namespace("cv::superres") public static native @Ptr FrameSource createFrameSource_Video(@Str BytePointer fileName);
        @Namespace("cv::superres") public static native @Ptr FrameSource createFrameSource_Video(@Str String fileName);
        @Namespace("cv::superres") public static native @Ptr FrameSource createFrameSource_Video_CUDA(@Str BytePointer fileName);
        @Namespace("cv::superres") public static native @Ptr FrameSource createFrameSource_Video_CUDA(@Str String fileName);

        @Namespace("cv::superres") public static native @Ptr FrameSource createFrameSource_Camera(int deviceId/*=0*/);
        @Namespace("cv::superres") public static native @Ptr FrameSource createFrameSource_Camera();

        /** @brief Base class for Super Resolution algorithms.

        The class is only used to define the common interface for the whole family of Super Resolution
        algorithms.
         */
        @Namespace("cv::superres") @NoOffset public static class SuperResolution extends Algorithm {
            static { Loader.load(); }
            /** Empty constructor. */
            public SuperResolution() { }
            /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
            public SuperResolution(Pointer p) { super(p); }
            public FrameSource asFrameSource() { return asFrameSource(this); }
            @Namespace public static native @Name("static_cast<cv::superres::FrameSource*>") FrameSource asFrameSource(SuperResolution pointer);
        
            /** @brief Set input frame source for Super Resolution algorithm.

            @param frameSource Input frame source
             */
            public native void setInput(@Ptr FrameSource frameSource);

            /** @brief Process next frame from input and return output result.

            @param frame Output result
             */
            public native void nextFrame(@ByVal Mat frame);
            public native void reset();

            /** @brief Clear all inner buffers.
            */
            public native void collectGarbage();

            /** @brief Scale factor
            /** @see setScale */
            public native int getScale();
            /** @copybrief getScale @see getScale */
            public native void setScale(int val);

            /** @brief Iterations count
            /** @see setIterations */
            public native int getIterations();
            /** @copybrief getIterations @see getIterations */
            public native void setIterations(int val);

            /** @brief Asymptotic value of steepest descent method
            /** @see setTau */
            public native double getTau();
            /** @copybrief getTau @see getTau */
            public native void setTau(double val);

            /** @brief Weight parameter to balance data term and smoothness term
            /** @see setLabmda */
            public native double getLabmda();
            /** @copybrief getLabmda @see getLabmda */
            public native void setLabmda(double val);

            /** @brief Parameter of spacial distribution in Bilateral-TV
            /** @see setAlpha */
            public native double getAlpha();
            /** @copybrief getAlpha @see getAlpha */
            public native void setAlpha(double val);

            /** @brief Kernel size of Bilateral-TV filter
            /** @see setKernelSize */
            public native int getKernelSize();
            /** @copybrief getKernelSize @see getKernelSize */
            public native void setKernelSize(int val);

            /** @brief Gaussian blur kernel size
            /** @see setBlurKernelSize */
            public native int getBlurKernelSize();
            /** @copybrief getBlurKernelSize @see getBlurKernelSize */
            public native void setBlurKernelSize(int val);

            /** @brief Gaussian blur sigma
            /** @see setBlurSigma */
            public native double getBlurSigma();
            /** @copybrief getBlurSigma @see getBlurSigma */
            public native void setBlurSigma(double val);

            /** @brief Radius of the temporal search area
            /** @see setTemporalAreaRadius */
            public native int getTemporalAreaRadius();
            /** @copybrief getTemporalAreaRadius @see getTemporalAreaRadius */
            public native void setTemporalAreaRadius(int val);

            /** @brief Dense optical flow algorithm
            /** @see setOpticalFlow */
            public native @Ptr DenseOpticalFlowExt getOpticalFlow();
            /** @copybrief getOpticalFlow @see getOpticalFlow */
            public native void setOpticalFlow(@Ptr DenseOpticalFlowExt val);
        }

        /** @brief Create Bilateral TV-L1 Super Resolution.

        This class implements Super Resolution algorithm described in the papers @cite Farsiu03 and
        @cite Mitzel09 .

        Here are important members of the class that control the algorithm, which you can set after
        constructing the class instance:

        -   **int scale** Scale factor.
        -   **int iterations** Iteration count.
        -   **double tau** Asymptotic value of steepest descent method.
        -   **double lambda** Weight parameter to balance data term and smoothness term.
        -   **double alpha** Parameter of spacial distribution in Bilateral-TV.
        -   **int btvKernelSize** Kernel size of Bilateral-TV filter.
        -   **int blurKernelSize** Gaussian blur kernel size.
        -   **double blurSigma** Gaussian blur sigma.
        -   **int temporalAreaRadius** Radius of the temporal search area.
        -   **Ptr\<DenseOpticalFlowExt\> opticalFlow** Dense optical flow algorithm.
         */
        @Namespace("cv::superres") public static native @Ptr SuperResolution createSuperResolution_BTVL1();
        @Namespace("cv::superres") public static native @Ptr SuperResolution createSuperResolution_BTVL1_CUDA();

/** @} superres */

    


// #endif // __OPENCV_SUPERRES_HPP__


// Parsed from <opencv2/superres/optical_flow.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_SUPERRES_OPTICAL_FLOW_HPP__
// #define __OPENCV_SUPERRES_OPTICAL_FLOW_HPP__

// #include "opencv2/core.hpp"

/** @addtogroup superres
 *  @{ */

        @Namespace("cv::superres") public static class DenseOpticalFlowExt extends Algorithm {
            static { Loader.load(); }
            /** Empty constructor. */
            public DenseOpticalFlowExt() { }
            /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
            public DenseOpticalFlowExt(Pointer p) { super(p); }
        
            public native void calc(@ByVal Mat frame0, @ByVal Mat frame1, @ByVal Mat flow1, @ByVal(nullValue = "cv::noArray()") Mat flow2/*=cv::noArray()*/);
            public native void calc(@ByVal Mat frame0, @ByVal Mat frame1, @ByVal Mat flow1);
            public native void collectGarbage();
        }


        @Namespace("cv::superres") public static class FarnebackOpticalFlow extends DenseOpticalFlowExt {
            static { Loader.load(); }
            /** Empty constructor. */
            public FarnebackOpticalFlow() { }
            /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
            public FarnebackOpticalFlow(Pointer p) { super(p); }
        
            /** @see setPyrScale */
            public native double getPyrScale();
            /** @copybrief getPyrScale @see getPyrScale */
            public native void setPyrScale(double val);
            /** @see setLevelsNumber */
            public native int getLevelsNumber();
            /** @copybrief getLevelsNumber @see getLevelsNumber */
            public native void setLevelsNumber(int val);
            /** @see setWindowSize */
            public native int getWindowSize();
            /** @copybrief getWindowSize @see getWindowSize */
            public native void setWindowSize(int val);
            /** @see setIterations */
            public native int getIterations();
            /** @copybrief getIterations @see getIterations */
            public native void setIterations(int val);
            /** @see setPolyN */
            public native int getPolyN();
            /** @copybrief getPolyN @see getPolyN */
            public native void setPolyN(int val);
            /** @see setPolySigma */
            public native double getPolySigma();
            /** @copybrief getPolySigma @see getPolySigma */
            public native void setPolySigma(double val);
            /** @see setFlags */
            public native int getFlags();
            /** @copybrief getFlags @see getFlags */
            public native void setFlags(int val);
        }
        @Namespace("cv::superres") public static native @Ptr FarnebackOpticalFlow createOptFlow_Farneback();
        @Namespace("cv::superres") public static native @Ptr FarnebackOpticalFlow createOptFlow_Farneback_CUDA();


//        CV_EXPORTS Ptr<DenseOpticalFlowExt> createOptFlow_Simple();


        @Name("cv::superres::DualTVL1OpticalFlow") public static class SuperResDualTVL1OpticalFlow extends DenseOpticalFlowExt {
            static { Loader.load(); }
            /** Empty constructor. */
            public SuperResDualTVL1OpticalFlow() { }
            /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
            public SuperResDualTVL1OpticalFlow(Pointer p) { super(p); }
        
            /** @see setTau */
            public native double getTau();
            /** @copybrief getTau @see getTau */
            public native void setTau(double val);
            /** @see setLambda */
            public native double getLambda();
            /** @copybrief getLambda @see getLambda */
            public native void setLambda(double val);
            /** @see setTheta */
            public native double getTheta();
            /** @copybrief getTheta @see getTheta */
            public native void setTheta(double val);
            /** @see setScalesNumber */
            public native int getScalesNumber();
            /** @copybrief getScalesNumber @see getScalesNumber */
            public native void setScalesNumber(int val);
            /** @see setWarpingsNumber */
            public native int getWarpingsNumber();
            /** @copybrief getWarpingsNumber @see getWarpingsNumber */
            public native void setWarpingsNumber(int val);
            /** @see setEpsilon */
            public native double getEpsilon();
            /** @copybrief getEpsilon @see getEpsilon */
            public native void setEpsilon(double val);
            /** @see setIterations */
            public native int getIterations();
            /** @copybrief getIterations @see getIterations */
            public native void setIterations(int val);
            /** @see setUseInitialFlow */
            public native @Cast("bool") boolean getUseInitialFlow();
            /** @copybrief getUseInitialFlow @see getUseInitialFlow */
            public native void setUseInitialFlow(@Cast("bool") boolean val);
        }
        @Namespace("cv::superres") public static native @Ptr SuperResDualTVL1OpticalFlow createOptFlow_DualTVL1();
        @Namespace("cv::superres") public static native @Ptr SuperResDualTVL1OpticalFlow createOptFlow_DualTVL1_CUDA();


        @Namespace("cv::superres") public static class BroxOpticalFlow extends DenseOpticalFlowExt {
            static { Loader.load(); }
            /** Empty constructor. */
            public BroxOpticalFlow() { }
            /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
            public BroxOpticalFlow(Pointer p) { super(p); }
        
            /** @brief Flow smoothness
            /** @see setAlpha */
            public native double getAlpha();
            /** @copybrief getAlpha @see getAlpha */
            public native void setAlpha(double val);
            /** @brief Gradient constancy importance
            /** @see setGamma */
            public native double getGamma();
            /** @copybrief getGamma @see getGamma */
            public native void setGamma(double val);
            /** @brief Pyramid scale factor
            /** @see setScaleFactor */
            public native double getScaleFactor();
            /** @copybrief getScaleFactor @see getScaleFactor */
            public native void setScaleFactor(double val);
            /** @brief Number of lagged non-linearity iterations (inner loop)
            /** @see setInnerIterations */
            public native int getInnerIterations();
            /** @copybrief getInnerIterations @see getInnerIterations */
            public native void setInnerIterations(int val);
            /** @brief Number of warping iterations (number of pyramid levels)
            /** @see setOuterIterations */
            public native int getOuterIterations();
            /** @copybrief getOuterIterations @see getOuterIterations */
            public native void setOuterIterations(int val);
            /** @brief Number of linear system solver iterations
            /** @see setSolverIterations */
            public native int getSolverIterations();
            /** @copybrief getSolverIterations @see getSolverIterations */
            public native void setSolverIterations(int val);
        }
        @Namespace("cv::superres") public static native @Ptr BroxOpticalFlow createOptFlow_Brox_CUDA();


        @Namespace("cv::superres") public static class PyrLKOpticalFlow extends DenseOpticalFlowExt {
            static { Loader.load(); }
            /** Empty constructor. */
            public PyrLKOpticalFlow() { }
            /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
            public PyrLKOpticalFlow(Pointer p) { super(p); }
        
            /** @see setWindowSize */
            public native int getWindowSize();
            /** @copybrief getWindowSize @see getWindowSize */
            public native void setWindowSize(int val);
            /** @see setMaxLevel */
            public native int getMaxLevel();
            /** @copybrief getMaxLevel @see getMaxLevel */
            public native void setMaxLevel(int val);
            /** @see setIterations */
            public native int getIterations();
            /** @copybrief getIterations @see getIterations */
            public native void setIterations(int val);
        }
        @Namespace("cv::superres") public static native @Ptr PyrLKOpticalFlow createOptFlow_PyrLK_CUDA();

/** @} */

    


// #endif // __OPENCV_SUPERRES_OPTICAL_FLOW_HPP__


}
