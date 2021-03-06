/*
 * Copyright (C) 2011-2015 Samuel Audet
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

#include <opencv2/core/core_c.h>
#include <opencv2/core/core.hpp>
#define explicit // Make all constructors of Affine3<T> implicit
#include <opencv2/core/affine.hpp>
#undef explicit

#ifdef _WIN32
#include <windows.h>
#undef min
#undef max
#endif
static inline void SetLibraryPath(const char *path) {
#if _WIN32_WINNT >= 0x0502
    SetDllDirectory(path);
#endif
}

template<class T> class PtrAdapter {
public:
    PtrAdapter(const T* ptr, int size)  : ptr((T*)ptr), size(size), cvPtr2((T*)ptr), cvPtr(cvPtr2) { }
    PtrAdapter(const cv::Ptr<T>& cvPtr) : ptr(0), size(0), cvPtr2(cvPtr), cvPtr(cvPtr2) { }
    PtrAdapter(      cv::Ptr<T>& cvPtr) : ptr(0), size(0), cvPtr(cvPtr) { }
    void assign(T* ptr, int size) {
        this->ptr = ptr;
        this->size = size;
        this->cvPtr = ptr;
    }
    static void deallocate(void* ptr) { cv::Ptr<T> deallocator((T*)ptr); }
    operator T*() {
        // take ownership, if unique
        ptr = cvPtr.get();
        if (&cvPtr == &cvPtr2) {
            // hack to set cvPtr.owner->owned = NULL
            *(T**)&cvPtr = NULL;
        }
        return ptr;
    }
    operator const T*()    { return cvPtr.get(); }
    operator cv::Ptr<T>&() { return cvPtr; }
    operator cv::Ptr<T>*() { return ptr ? &cvPtr : 0; }
    T* ptr;
    int size;
    cv::Ptr<T> cvPtr2;
    cv::Ptr<T>& cvPtr;
};

class StrAdapter {
public:
    StrAdapter(const          char* ptr, size_t size) : ptr((char*)ptr), size(size),
        str2(ptr ? (char*)ptr : ""), str(str2) { }
    StrAdapter(const signed   char* ptr, size_t size) : ptr((char*)ptr), size(size),
        str2(ptr ? (char*)ptr : ""), str(str2) { }
    StrAdapter(const unsigned char* ptr, size_t size) : ptr((char*)ptr), size(size),
        str2(ptr ? (char*)ptr : ""), str(str2) { }
    StrAdapter(const cv::String& str) : ptr(0), size(0), str2(str), str(str2) { }
    StrAdapter(      cv::String& str) : ptr(0), size(0), str(str) { }
    void assign(char* ptr, size_t size) {
        this->ptr = ptr;
        this->size = size;
        str = ptr ? ptr : "";
    }
    static void deallocate(void* ptr) { free(ptr); }
    operator char*() {
        const char* c_str = str.c_str();
        if (ptr == NULL || strcmp(c_str, ptr) != 0) {
            ptr = strdup(c_str);
        }
        size = strlen(c_str) + 1;
        return ptr;
    }
    operator       signed   char*() { return (signed   char*)(operator char*)(); }
    operator       unsigned char*() { return (unsigned char*)(operator char*)(); }
    operator const          char*() { return                 str.c_str(); }
    operator const signed   char*() { return (signed   char*)str.c_str(); }
    operator const unsigned char*() { return (unsigned char*)str.c_str(); }
    operator         cv::String&() { return str; }
    operator         cv::String*() { return ptr ? &str : 0; }
    char* ptr;
    size_t size;
    cv::String str2;
    cv::String& str;
};
