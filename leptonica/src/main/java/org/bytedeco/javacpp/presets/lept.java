/*
 * Copyright (C) 2014-2015 Samuel Audet
 *
 * Licensed either under the Apache License, Version 2.0, or (at your option)
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation (subject to the "Classpath" exception),
 * either version 2, or any later version (collectively, the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     http://www.gnu.org/licenses/
 *     http://www.gnu.org/software/classpath/license.html
 *
 * or as provided in the LICENSE.txt file that accompanied this code.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bytedeco.javacpp.presets;

import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

/**
 *
 * @author Samuel Audet
 */
@Properties(target="org.bytedeco.javacpp.lept", value={
    @Platform(include={"leptonica/alltypes.h", "leptonica/environ.h", "leptonica/array.h", "leptonica/bbuffer.h", "leptonica/heap.h", "leptonica/list.h",
        "leptonica/ptra.h", "leptonica/queue.h", "leptonica/stack.h", "leptonica/arrayaccess.h", "leptonica/bmf.h", "leptonica/ccbord.h",
        "leptonica/dewarp.h", "leptonica/gplot.h", "leptonica/imageio.h", "leptonica/jbclass.h", "leptonica/morph.h", "leptonica/pix.h",
        "leptonica/recog.h", "leptonica/regutils.h", "leptonica/stringcode.h", "leptonica/sudoku.h", "leptonica/watershed.h", "leptonica/allheaders.h"}, link="lept@.4",
        preload={"gif@.4", "jpeg@.62", "png16@.16", "tiff@.5", "webp@.5"}),
    @Platform(value="linux-x86", preloadpath={"/usr/lib32/", "/usr/lib/"}),
    @Platform(value="linux-x86_64", preloadpath={"/usr/lib64/", "/usr/lib/"}),
    @Platform(value="android", link="lept"),
    @Platform(value="windows", link="liblept", preload={"libwinpthread-1", "libgcc_s_sjlj-1", "libgcc_s_seh-1", "libstdc++-6",
        "zlib1", "libgif-6", "libjpeg-62", "libpng16-16", "libtiff-5", "libwebp-5", "liblept-4"}),
    @Platform(value="windows-x86", preloadpath="C:/Program Files (x86)/mingw-w64/i686-4.9.1-posix-sjlj-rt_v3-rev3/mingw32/bin/"),
    @Platform(value="windows-x86_64", preloadpath="C:/Program Files/mingw-w64/x86_64-4.9.1-posix-seh-rt_v3-rev3/mingw64/bin/") })
public class lept implements InfoMapper {
    public void map(InfoMap infoMap) {
        infoMap.put(new Info("LEPT_DLL", "LIBJP2K_HEADER", "L_END_LIST").cppTypes().annotations())
               .put(new Info("L_WallTimer").pointerTypes("L_WALLTIMER"))
               .put(new Info("Numa").pointerTypes("NUMA"))
               .put(new Info("Numaa").pointerTypes("NUMAA"))
               .put(new Info("Numa2d").pointerTypes("NUMA2D"))
               .put(new Info("NumaHash").pointerTypes("NUMAHASH"))
               .put(new Info("L_Dna").pointerTypes("L_DNA"))
               .put(new Info("L_Dnaa").pointerTypes("L_DNAA"))
               .put(new Info("Sarray").pointerTypes("SARRAY"))
               .put(new Info("L_Bytea").pointerTypes("L_BYTEA"))
               .put(new Info("ByteBuffer").pointerTypes("BBUFFER"))
               .put(new Info("L_Heap").pointerTypes("L_HEAP"))
               .put(new Info("DoubleLinkedList").pointerTypes("DLLIST"))
               .put(new Info("L_Ptra").pointerTypes("L_PTRA"))
               .put(new Info("L_Ptraa").pointerTypes("L_PTRAA"))
               .put(new Info("L_Queue").pointerTypes("L_QUEUE"))
               .put(new Info("L_Stack").pointerTypes("L_STACK"))
               .put(new Info("L_Bmf").pointerTypes("L_BMF"))
               .put(new Info("CCBord").pointerTypes("CCBORD"))
               .put(new Info("CCBorda").pointerTypes("CCBORDA"))
               .put(new Info("L_Dewarpa").pointerTypes("L_DEWARPA"))
               .put(new Info("L_Dewarp").pointerTypes("L_DEWARP"))
               .put(new Info("GPlot").pointerTypes("GPLOT"))
               .put(new Info("L_Compressed_Data").pointerTypes("L_COMP_DATA"))
               .put(new Info("L_Pdf_Data").pointerTypes("L_PDF_DATA"))
               .put(new Info("JbClasser").pointerTypes("JBCLASSER"))
               .put(new Info("JbData").pointerTypes("JBDATA"))
               .put(new Info("Sel").pointerTypes("SEL"))
               .put(new Info("Sela").pointerTypes("SELA"))
               .put(new Info("L_Kernel").pointerTypes("L_KERNEL"))
               .put(new Info("Pix").pointerTypes("PIX"))
               .put(new Info("PixColormap").pointerTypes("PIXCMAP"))
               .put(new Info("RGBA_Quad").pointerTypes("RGBA_QUAD"))
               .put(new Info("Pixa").pointerTypes("PIXA"))
               .put(new Info("Pixaa").pointerTypes("PIXAA"))
               .put(new Info("Box").pointerTypes("BOX"))
               .put(new Info("Boxa").pointerTypes("BOXA"))
               .put(new Info("Boxaa").pointerTypes("BOXAA"))
               .put(new Info("Pta").pointerTypes("PTA"))
               .put(new Info("Ptaa").pointerTypes("PTAA"))
               .put(new Info("Pixacc").pointerTypes("PIXACC"))
               .put(new Info("PixTiling").pointerTypes("PIXTILING"))
               .put(new Info("FPix").pointerTypes("FPIX"))
               .put(new Info("FPixa").pointerTypes("FPIXA"))
               .put(new Info("DPix").pointerTypes("DPIX"))
               .put(new Info("PixComp").pointerTypes("PIXC"))
               .put(new Info("PixaComp").pointerTypes("PIXAC"))
               .put(new Info("L_Recoga").pointerTypes("L_RECOGA"))
               .put(new Info("L_Recog").pointerTypes("L_RECOG"))
               .put(new Info("L_Rch").pointerTypes("L_RCH"))
               .put(new Info("L_Rcha").pointerTypes("L_RCHA"))
               .put(new Info("L_Rdid").pointerTypes("L_RDID"))
               .put(new Info("L_RegParams").pointerTypes("L_REGPARAMS"))
               .put(new Info("L_StrCode").pointerTypes("L_STRCODE"))
               .put(new Info("L_Sudoku").pointerTypes("L_SUDOKU"))
               .put(new Info("L_WShed").pointerTypes("L_WSHED"));
    }
}
