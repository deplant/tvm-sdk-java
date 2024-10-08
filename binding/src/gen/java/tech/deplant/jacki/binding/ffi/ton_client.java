// Generated by jextract

package tech.deplant.jacki.binding.ffi;

import java.lang.invoke.*;
import java.lang.foreign.*;
import java.util.*;
import java.util.stream.*;

import static java.lang.foreign.ValueLayout.*;

public class ton_client {

    ton_client() {
        // Should not be called directly
    }

    static final Arena LIBRARY_ARENA = Arena.ofAuto();
    static final boolean TRACE_DOWNCALLS = Boolean.getBoolean("jextract.trace.downcalls");

    static void traceDowncall(String name, Object... args) {
         String traceArgs = Arrays.stream(args)
                       .map(Object::toString)
                       .collect(Collectors.joining(", "));
         System.out.printf("%s(%s)\n", name, traceArgs);
    }

    static MemorySegment findOrThrow(String symbol) {
        return SYMBOL_LOOKUP.find(symbol)
            .orElseThrow(() -> new UnsatisfiedLinkError("unresolved symbol: " + symbol));
    }

    static MethodHandle upcallHandle(Class<?> fi, String name, FunctionDescriptor fdesc) {
        try {
            return MethodHandles.lookup().findVirtual(fi, name, fdesc.toMethodType());
        } catch (ReflectiveOperationException ex) {
            throw new AssertionError(ex);
        }
    }

    static MemoryLayout align(MemoryLayout layout, long align) {
        return switch (layout) {
            case PaddingLayout p -> p;
            case ValueLayout v -> v.withByteAlignment(align);
            case GroupLayout g -> {
                MemoryLayout[] alignedMembers = g.memberLayouts().stream()
                        .map(m -> align(m, align)).toArray(MemoryLayout[]::new);
                yield g instanceof StructLayout ?
                        MemoryLayout.structLayout(alignedMembers) : MemoryLayout.unionLayout(alignedMembers);
            }
            case SequenceLayout s -> MemoryLayout.sequenceLayout(s.elementCount(), align(s.elementLayout(), align));
        };
    }

    static final SymbolLookup SYMBOL_LOOKUP = SymbolLookup.loaderLookup()
            .or(Linker.nativeLinker().defaultLookup());

    public static final ValueLayout.OfBoolean C_BOOL = ValueLayout.JAVA_BOOLEAN;
    public static final ValueLayout.OfByte C_CHAR = ValueLayout.JAVA_BYTE;
    public static final ValueLayout.OfShort C_SHORT = ValueLayout.JAVA_SHORT;
    public static final ValueLayout.OfInt C_INT = ValueLayout.JAVA_INT;
    public static final ValueLayout.OfLong C_LONG_LONG = ValueLayout.JAVA_LONG;
    public static final ValueLayout.OfFloat C_FLOAT = ValueLayout.JAVA_FLOAT;
    public static final ValueLayout.OfDouble C_DOUBLE = ValueLayout.JAVA_DOUBLE;
    public static final AddressLayout C_POINTER = ValueLayout.ADDRESS
            .withTargetLayout(MemoryLayout.sequenceLayout(java.lang.Long.MAX_VALUE, JAVA_BYTE));
    public static final ValueLayout.OfInt C_LONG = ValueLayout.JAVA_INT;
    public static final ValueLayout.OfDouble C_LONG_DOUBLE = ValueLayout.JAVA_DOUBLE;
    private static final int true_ = (int)1L;
    /**
     * {@snippet lang=c :
     * #define true 1
     * }
     */
    public static int true_() {
        return true_;
    }
    private static final int false_ = (int)0L;
    /**
     * {@snippet lang=c :
     * #define false 0
     * }
     */
    public static int false_() {
        return false_;
    }
    private static final int __bool_true_false_are_defined = (int)1L;
    /**
     * {@snippet lang=c :
     * #define __bool_true_false_are_defined 1
     * }
     */
    public static int __bool_true_false_are_defined() {
        return __bool_true_false_are_defined;
    }
    /**
     * {@snippet lang=c :
     * typedef long long int64_t
     * }
     */
    public static final OfLong int64_t = ton_client.C_LONG_LONG;
    /**
     * {@snippet lang=c :
     * typedef unsigned long long uint64_t
     * }
     */
    public static final OfLong uint64_t = ton_client.C_LONG_LONG;
    /**
     * {@snippet lang=c :
     * typedef int64_t int_least64_t
     * }
     */
    public static final OfLong int_least64_t = ton_client.C_LONG_LONG;
    /**
     * {@snippet lang=c :
     * typedef uint64_t uint_least64_t
     * }
     */
    public static final OfLong uint_least64_t = ton_client.C_LONG_LONG;
    /**
     * {@snippet lang=c :
     * typedef int64_t int_fast64_t
     * }
     */
    public static final OfLong int_fast64_t = ton_client.C_LONG_LONG;
    /**
     * {@snippet lang=c :
     * typedef uint64_t uint_fast64_t
     * }
     */
    public static final OfLong uint_fast64_t = ton_client.C_LONG_LONG;
    /**
     * {@snippet lang=c :
     * typedef int int32_t
     * }
     */
    public static final OfInt int32_t = ton_client.C_INT;
    /**
     * {@snippet lang=c :
     * typedef unsigned int uint32_t
     * }
     */
    public static final OfInt uint32_t = ton_client.C_INT;
    /**
     * {@snippet lang=c :
     * typedef int32_t int_least32_t
     * }
     */
    public static final OfInt int_least32_t = ton_client.C_INT;
    /**
     * {@snippet lang=c :
     * typedef uint32_t uint_least32_t
     * }
     */
    public static final OfInt uint_least32_t = ton_client.C_INT;
    /**
     * {@snippet lang=c :
     * typedef int32_t int_fast32_t
     * }
     */
    public static final OfInt int_fast32_t = ton_client.C_INT;
    /**
     * {@snippet lang=c :
     * typedef uint32_t uint_fast32_t
     * }
     */
    public static final OfInt uint_fast32_t = ton_client.C_INT;
    /**
     * {@snippet lang=c :
     * typedef short int16_t
     * }
     */
    public static final OfShort int16_t = ton_client.C_SHORT;
    /**
     * {@snippet lang=c :
     * typedef unsigned short uint16_t
     * }
     */
    public static final OfShort uint16_t = ton_client.C_SHORT;
    /**
     * {@snippet lang=c :
     * typedef int16_t int_least16_t
     * }
     */
    public static final OfShort int_least16_t = ton_client.C_SHORT;
    /**
     * {@snippet lang=c :
     * typedef uint16_t uint_least16_t
     * }
     */
    public static final OfShort uint_least16_t = ton_client.C_SHORT;
    /**
     * {@snippet lang=c :
     * typedef int16_t int_fast16_t
     * }
     */
    public static final OfShort int_fast16_t = ton_client.C_SHORT;
    /**
     * {@snippet lang=c :
     * typedef uint16_t uint_fast16_t
     * }
     */
    public static final OfShort uint_fast16_t = ton_client.C_SHORT;
    /**
     * {@snippet lang=c :
     * typedef signed char int8_t
     * }
     */
    public static final OfByte int8_t = ton_client.C_CHAR;
    /**
     * {@snippet lang=c :
     * typedef unsigned char uint8_t
     * }
     */
    public static final OfByte uint8_t = ton_client.C_CHAR;
    /**
     * {@snippet lang=c :
     * typedef int8_t int_least8_t
     * }
     */
    public static final OfByte int_least8_t = ton_client.C_CHAR;
    /**
     * {@snippet lang=c :
     * typedef uint8_t uint_least8_t
     * }
     */
    public static final OfByte uint_least8_t = ton_client.C_CHAR;
    /**
     * {@snippet lang=c :
     * typedef int8_t int_fast8_t
     * }
     */
    public static final OfByte int_fast8_t = ton_client.C_CHAR;
    /**
     * {@snippet lang=c :
     * typedef uint8_t uint_fast8_t
     * }
     */
    public static final OfByte uint_fast8_t = ton_client.C_CHAR;
    /**
     * {@snippet lang=c :
     * typedef long long intptr_t
     * }
     */
    public static final OfLong intptr_t = ton_client.C_LONG_LONG;
    /**
     * {@snippet lang=c :
     * typedef unsigned long long uintptr_t
     * }
     */
    public static final OfLong uintptr_t = ton_client.C_LONG_LONG;
    /**
     * {@snippet lang=c :
     * typedef long long intmax_t
     * }
     */
    public static final OfLong intmax_t = ton_client.C_LONG_LONG;
    /**
     * {@snippet lang=c :
     * typedef unsigned long long uintmax_t
     * }
     */
    public static final OfLong uintmax_t = ton_client.C_LONG_LONG;
    private static final int tc_response_success = (int)0L;
    /**
     * {@snippet lang=c :
     * enum tc_response_types.tc_response_success = 0
     * }
     */
    public static int tc_response_success() {
        return tc_response_success;
    }
    private static final int tc_response_error = (int)1L;
    /**
     * {@snippet lang=c :
     * enum tc_response_types.tc_response_error = 1
     * }
     */
    public static int tc_response_error() {
        return tc_response_error;
    }
    private static final int tc_response_nop = (int)2L;
    /**
     * {@snippet lang=c :
     * enum tc_response_types.tc_response_nop = 2
     * }
     */
    public static int tc_response_nop() {
        return tc_response_nop;
    }
    private static final int tc_response_app_request = (int)3L;
    /**
     * {@snippet lang=c :
     * enum tc_response_types.tc_response_app_request = 3
     * }
     */
    public static int tc_response_app_request() {
        return tc_response_app_request;
    }
    private static final int tc_response_app_notify = (int)4L;
    /**
     * {@snippet lang=c :
     * enum tc_response_types.tc_response_app_notify = 4
     * }
     */
    public static int tc_response_app_notify() {
        return tc_response_app_notify;
    }
    private static final int tc_response_custom = (int)100L;
    /**
     * {@snippet lang=c :
     * enum tc_response_types.tc_response_custom = 100
     * }
     */
    public static int tc_response_custom() {
        return tc_response_custom;
    }

    private static class tc_create_context {
        public static final FunctionDescriptor DESC = FunctionDescriptor.of(
            ton_client.C_POINTER,
            tc_string_data_t.layout()
        );

        public static final MemorySegment ADDR = ton_client.findOrThrow("tc_create_context");

        public static final MethodHandle HANDLE = Linker.nativeLinker().downcallHandle(ADDR, DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang=c :
     * tc_string_handle_t *tc_create_context(tc_string_data_t config)
     * }
     */
    public static FunctionDescriptor tc_create_context$descriptor() {
        return tc_create_context.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang=c :
     * tc_string_handle_t *tc_create_context(tc_string_data_t config)
     * }
     */
    public static MethodHandle tc_create_context$handle() {
        return tc_create_context.HANDLE;
    }

    /**
     * Address for:
     * {@snippet lang=c :
     * tc_string_handle_t *tc_create_context(tc_string_data_t config)
     * }
     */
    public static MemorySegment tc_create_context$address() {
        return tc_create_context.ADDR;
    }

    /**
     * {@snippet lang=c :
     * tc_string_handle_t *tc_create_context(tc_string_data_t config)
     * }
     */
    public static MemorySegment tc_create_context(MemorySegment config) {
        var mh$ = tc_create_context.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("tc_create_context", config);
            }
            return (MemorySegment)mh$.invokeExact(config);
        } catch (Throwable ex$) {
           throw new AssertionError("should not reach here", ex$);
        }
    }

    private static class tc_destroy_context {
        public static final FunctionDescriptor DESC = FunctionDescriptor.ofVoid(
            ton_client.C_INT
        );

        public static final MemorySegment ADDR = ton_client.findOrThrow("tc_destroy_context");

        public static final MethodHandle HANDLE = Linker.nativeLinker().downcallHandle(ADDR, DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang=c :
     * void tc_destroy_context(uint32_t context)
     * }
     */
    public static FunctionDescriptor tc_destroy_context$descriptor() {
        return tc_destroy_context.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang=c :
     * void tc_destroy_context(uint32_t context)
     * }
     */
    public static MethodHandle tc_destroy_context$handle() {
        return tc_destroy_context.HANDLE;
    }

    /**
     * Address for:
     * {@snippet lang=c :
     * void tc_destroy_context(uint32_t context)
     * }
     */
    public static MemorySegment tc_destroy_context$address() {
        return tc_destroy_context.ADDR;
    }

    /**
     * {@snippet lang=c :
     * void tc_destroy_context(uint32_t context)
     * }
     */
    public static void tc_destroy_context(int context) {
        var mh$ = tc_destroy_context.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("tc_destroy_context", context);
            }
            mh$.invokeExact(context);
        } catch (Throwable ex$) {
           throw new AssertionError("should not reach here", ex$);
        }
    }

    private static class tc_request {
        public static final FunctionDescriptor DESC = FunctionDescriptor.ofVoid(
            ton_client.C_INT,
            tc_string_data_t.layout(),
            tc_string_data_t.layout(),
            ton_client.C_INT,
            ton_client.C_POINTER
        );

        public static final MemorySegment ADDR = ton_client.findOrThrow("tc_request");

        public static final MethodHandle HANDLE = Linker.nativeLinker().downcallHandle(ADDR, DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang=c :
     * void tc_request(uint32_t context, tc_string_data_t function_name, tc_string_data_t function_params_json, uint32_t request_id, tc_response_handler_t response_handler)
     * }
     */
    public static FunctionDescriptor tc_request$descriptor() {
        return tc_request.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang=c :
     * void tc_request(uint32_t context, tc_string_data_t function_name, tc_string_data_t function_params_json, uint32_t request_id, tc_response_handler_t response_handler)
     * }
     */
    public static MethodHandle tc_request$handle() {
        return tc_request.HANDLE;
    }

    /**
     * Address for:
     * {@snippet lang=c :
     * void tc_request(uint32_t context, tc_string_data_t function_name, tc_string_data_t function_params_json, uint32_t request_id, tc_response_handler_t response_handler)
     * }
     */
    public static MemorySegment tc_request$address() {
        return tc_request.ADDR;
    }

    /**
     * {@snippet lang=c :
     * void tc_request(uint32_t context, tc_string_data_t function_name, tc_string_data_t function_params_json, uint32_t request_id, tc_response_handler_t response_handler)
     * }
     */
    public static void tc_request(int context, MemorySegment function_name, MemorySegment function_params_json, int request_id, MemorySegment response_handler) {
        var mh$ = tc_request.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("tc_request", context, function_name, function_params_json, request_id, response_handler);
            }
            mh$.invokeExact(context, function_name, function_params_json, request_id, response_handler);
        } catch (Throwable ex$) {
           throw new AssertionError("should not reach here", ex$);
        }
    }

    private static class tc_request_ptr {
        public static final FunctionDescriptor DESC = FunctionDescriptor.ofVoid(
            ton_client.C_INT,
            tc_string_data_t.layout(),
            tc_string_data_t.layout(),
            ton_client.C_POINTER,
            ton_client.C_POINTER
        );

        public static final MemorySegment ADDR = ton_client.findOrThrow("tc_request_ptr");

        public static final MethodHandle HANDLE = Linker.nativeLinker().downcallHandle(ADDR, DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang=c :
     * void tc_request_ptr(uint32_t context, tc_string_data_t function_name, tc_string_data_t function_params_json, void *request_ptr, tc_response_handler_ptr_t response_handler)
     * }
     */
    public static FunctionDescriptor tc_request_ptr$descriptor() {
        return tc_request_ptr.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang=c :
     * void tc_request_ptr(uint32_t context, tc_string_data_t function_name, tc_string_data_t function_params_json, void *request_ptr, tc_response_handler_ptr_t response_handler)
     * }
     */
    public static MethodHandle tc_request_ptr$handle() {
        return tc_request_ptr.HANDLE;
    }

    /**
     * Address for:
     * {@snippet lang=c :
     * void tc_request_ptr(uint32_t context, tc_string_data_t function_name, tc_string_data_t function_params_json, void *request_ptr, tc_response_handler_ptr_t response_handler)
     * }
     */
    public static MemorySegment tc_request_ptr$address() {
        return tc_request_ptr.ADDR;
    }

    /**
     * {@snippet lang=c :
     * void tc_request_ptr(uint32_t context, tc_string_data_t function_name, tc_string_data_t function_params_json, void *request_ptr, tc_response_handler_ptr_t response_handler)
     * }
     */
    public static void tc_request_ptr(int context, MemorySegment function_name, MemorySegment function_params_json, MemorySegment request_ptr, MemorySegment response_handler) {
        var mh$ = tc_request_ptr.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("tc_request_ptr", context, function_name, function_params_json, request_ptr, response_handler);
            }
            mh$.invokeExact(context, function_name, function_params_json, request_ptr, response_handler);
        } catch (Throwable ex$) {
           throw new AssertionError("should not reach here", ex$);
        }
    }

    private static class tc_request_sync {
        public static final FunctionDescriptor DESC = FunctionDescriptor.of(
            ton_client.C_POINTER,
            ton_client.C_INT,
            tc_string_data_t.layout(),
            tc_string_data_t.layout()
        );

        public static final MemorySegment ADDR = ton_client.findOrThrow("tc_request_sync");

        public static final MethodHandle HANDLE = Linker.nativeLinker().downcallHandle(ADDR, DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang=c :
     * tc_string_handle_t *tc_request_sync(uint32_t context, tc_string_data_t function_name, tc_string_data_t function_params_json)
     * }
     */
    public static FunctionDescriptor tc_request_sync$descriptor() {
        return tc_request_sync.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang=c :
     * tc_string_handle_t *tc_request_sync(uint32_t context, tc_string_data_t function_name, tc_string_data_t function_params_json)
     * }
     */
    public static MethodHandle tc_request_sync$handle() {
        return tc_request_sync.HANDLE;
    }

    /**
     * Address for:
     * {@snippet lang=c :
     * tc_string_handle_t *tc_request_sync(uint32_t context, tc_string_data_t function_name, tc_string_data_t function_params_json)
     * }
     */
    public static MemorySegment tc_request_sync$address() {
        return tc_request_sync.ADDR;
    }

    /**
     * {@snippet lang=c :
     * tc_string_handle_t *tc_request_sync(uint32_t context, tc_string_data_t function_name, tc_string_data_t function_params_json)
     * }
     */
    public static MemorySegment tc_request_sync(int context, MemorySegment function_name, MemorySegment function_params_json) {
        var mh$ = tc_request_sync.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("tc_request_sync", context, function_name, function_params_json);
            }
            return (MemorySegment)mh$.invokeExact(context, function_name, function_params_json);
        } catch (Throwable ex$) {
           throw new AssertionError("should not reach here", ex$);
        }
    }

    private static class tc_read_string {
        public static final FunctionDescriptor DESC = FunctionDescriptor.of(
            tc_string_data_t.layout(),
            ton_client.C_POINTER
        );

        public static final MemorySegment ADDR = ton_client.findOrThrow("tc_read_string");

        public static final MethodHandle HANDLE = Linker.nativeLinker().downcallHandle(ADDR, DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang=c :
     * tc_string_data_t tc_read_string(const tc_string_handle_t *handle)
     * }
     */
    public static FunctionDescriptor tc_read_string$descriptor() {
        return tc_read_string.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang=c :
     * tc_string_data_t tc_read_string(const tc_string_handle_t *handle)
     * }
     */
    public static MethodHandle tc_read_string$handle() {
        return tc_read_string.HANDLE;
    }

    /**
     * Address for:
     * {@snippet lang=c :
     * tc_string_data_t tc_read_string(const tc_string_handle_t *handle)
     * }
     */
    public static MemorySegment tc_read_string$address() {
        return tc_read_string.ADDR;
    }

    /**
     * {@snippet lang=c :
     * tc_string_data_t tc_read_string(const tc_string_handle_t *handle)
     * }
     */
    public static MemorySegment tc_read_string(SegmentAllocator allocator, MemorySegment handle) {
        var mh$ = tc_read_string.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("tc_read_string", allocator, handle);
            }
            return (MemorySegment)mh$.invokeExact(allocator, handle);
        } catch (Throwable ex$) {
           throw new AssertionError("should not reach here", ex$);
        }
    }

    private static class tc_destroy_string {
        public static final FunctionDescriptor DESC = FunctionDescriptor.ofVoid(
            ton_client.C_POINTER
        );

        public static final MemorySegment ADDR = ton_client.findOrThrow("tc_destroy_string");

        public static final MethodHandle HANDLE = Linker.nativeLinker().downcallHandle(ADDR, DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang=c :
     * void tc_destroy_string(const tc_string_handle_t *handle)
     * }
     */
    public static FunctionDescriptor tc_destroy_string$descriptor() {
        return tc_destroy_string.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang=c :
     * void tc_destroy_string(const tc_string_handle_t *handle)
     * }
     */
    public static MethodHandle tc_destroy_string$handle() {
        return tc_destroy_string.HANDLE;
    }

    /**
     * Address for:
     * {@snippet lang=c :
     * void tc_destroy_string(const tc_string_handle_t *handle)
     * }
     */
    public static MemorySegment tc_destroy_string$address() {
        return tc_destroy_string.ADDR;
    }

    /**
     * {@snippet lang=c :
     * void tc_destroy_string(const tc_string_handle_t *handle)
     * }
     */
    public static void tc_destroy_string(MemorySegment handle) {
        var mh$ = tc_destroy_string.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("tc_destroy_string", handle);
            }
            mh$.invokeExact(handle);
        } catch (Throwable ex$) {
           throw new AssertionError("should not reach here", ex$);
        }
    }
    private static final long INT64_MAX = 9223372036854775807L;
    /**
     * {@snippet lang=c :
     * #define INT64_MAX 9223372036854775807
     * }
     */
    public static long INT64_MAX() {
        return INT64_MAX;
    }
    private static final long INT64_MIN = -9223372036854775808L;
    /**
     * {@snippet lang=c :
     * #define INT64_MIN -9223372036854775808
     * }
     */
    public static long INT64_MIN() {
        return INT64_MIN;
    }
    private static final long UINT64_MAX = -1L;
    /**
     * {@snippet lang=c :
     * #define UINT64_MAX -1
     * }
     */
    public static long UINT64_MAX() {
        return UINT64_MAX;
    }
    private static final long __INT_LEAST64_MIN = -9223372036854775808L;
    /**
     * {@snippet lang=c :
     * #define __INT_LEAST64_MIN -9223372036854775808
     * }
     */
    public static long __INT_LEAST64_MIN() {
        return __INT_LEAST64_MIN;
    }
    private static final long __INT_LEAST64_MAX = 9223372036854775807L;
    /**
     * {@snippet lang=c :
     * #define __INT_LEAST64_MAX 9223372036854775807
     * }
     */
    public static long __INT_LEAST64_MAX() {
        return __INT_LEAST64_MAX;
    }
    private static final long __UINT_LEAST64_MAX = -1L;
    /**
     * {@snippet lang=c :
     * #define __UINT_LEAST64_MAX -1
     * }
     */
    public static long __UINT_LEAST64_MAX() {
        return __UINT_LEAST64_MAX;
    }
    private static final int __INT_LEAST32_MIN = (int)-2147483648L;
    /**
     * {@snippet lang=c :
     * #define __INT_LEAST32_MIN -2147483648
     * }
     */
    public static int __INT_LEAST32_MIN() {
        return __INT_LEAST32_MIN;
    }
    private static final int __INT_LEAST32_MAX = (int)2147483647L;
    /**
     * {@snippet lang=c :
     * #define __INT_LEAST32_MAX 2147483647
     * }
     */
    public static int __INT_LEAST32_MAX() {
        return __INT_LEAST32_MAX;
    }
    private static final int __UINT_LEAST32_MAX = (int)4294967295L;
    /**
     * {@snippet lang=c :
     * #define __UINT_LEAST32_MAX 4294967295
     * }
     */
    public static int __UINT_LEAST32_MAX() {
        return __UINT_LEAST32_MAX;
    }
    private static final int __INT_LEAST16_MIN = (int)-32768L;
    /**
     * {@snippet lang=c :
     * #define __INT_LEAST16_MIN -32768
     * }
     */
    public static int __INT_LEAST16_MIN() {
        return __INT_LEAST16_MIN;
    }
    private static final int __INT_LEAST16_MAX = (int)32767L;
    /**
     * {@snippet lang=c :
     * #define __INT_LEAST16_MAX 32767
     * }
     */
    public static int __INT_LEAST16_MAX() {
        return __INT_LEAST16_MAX;
    }
    private static final int __UINT_LEAST16_MAX = (int)65535L;
    /**
     * {@snippet lang=c :
     * #define __UINT_LEAST16_MAX 65535
     * }
     */
    public static int __UINT_LEAST16_MAX() {
        return __UINT_LEAST16_MAX;
    }
    private static final int __INT_LEAST8_MIN = (int)-128L;
    /**
     * {@snippet lang=c :
     * #define __INT_LEAST8_MIN -128
     * }
     */
    public static int __INT_LEAST8_MIN() {
        return __INT_LEAST8_MIN;
    }
    private static final int __INT_LEAST8_MAX = (int)127L;
    /**
     * {@snippet lang=c :
     * #define __INT_LEAST8_MAX 127
     * }
     */
    public static int __INT_LEAST8_MAX() {
        return __INT_LEAST8_MAX;
    }
    private static final int __UINT_LEAST8_MAX = (int)255L;
    /**
     * {@snippet lang=c :
     * #define __UINT_LEAST8_MAX 255
     * }
     */
    public static int __UINT_LEAST8_MAX() {
        return __UINT_LEAST8_MAX;
    }
    private static final long INT_LEAST64_MIN = -9223372036854775808L;
    /**
     * {@snippet lang=c :
     * #define INT_LEAST64_MIN -9223372036854775808
     * }
     */
    public static long INT_LEAST64_MIN() {
        return INT_LEAST64_MIN;
    }
    private static final long INT_LEAST64_MAX = 9223372036854775807L;
    /**
     * {@snippet lang=c :
     * #define INT_LEAST64_MAX 9223372036854775807
     * }
     */
    public static long INT_LEAST64_MAX() {
        return INT_LEAST64_MAX;
    }
    private static final long UINT_LEAST64_MAX = -1L;
    /**
     * {@snippet lang=c :
     * #define UINT_LEAST64_MAX -1
     * }
     */
    public static long UINT_LEAST64_MAX() {
        return UINT_LEAST64_MAX;
    }
    private static final long INT_FAST64_MIN = -9223372036854775808L;
    /**
     * {@snippet lang=c :
     * #define INT_FAST64_MIN -9223372036854775808
     * }
     */
    public static long INT_FAST64_MIN() {
        return INT_FAST64_MIN;
    }
    private static final long INT_FAST64_MAX = 9223372036854775807L;
    /**
     * {@snippet lang=c :
     * #define INT_FAST64_MAX 9223372036854775807
     * }
     */
    public static long INT_FAST64_MAX() {
        return INT_FAST64_MAX;
    }
    private static final long UINT_FAST64_MAX = -1L;
    /**
     * {@snippet lang=c :
     * #define UINT_FAST64_MAX -1
     * }
     */
    public static long UINT_FAST64_MAX() {
        return UINT_FAST64_MAX;
    }
    private static final int INT32_MAX = (int)2147483647L;
    /**
     * {@snippet lang=c :
     * #define INT32_MAX 2147483647
     * }
     */
    public static int INT32_MAX() {
        return INT32_MAX;
    }
    private static final int INT32_MIN = (int)-2147483648L;
    /**
     * {@snippet lang=c :
     * #define INT32_MIN -2147483648
     * }
     */
    public static int INT32_MIN() {
        return INT32_MIN;
    }
    private static final int UINT32_MAX = (int)4294967295L;
    /**
     * {@snippet lang=c :
     * #define UINT32_MAX 4294967295
     * }
     */
    public static int UINT32_MAX() {
        return UINT32_MAX;
    }
    private static final int INT_LEAST32_MIN = (int)-2147483648L;
    /**
     * {@snippet lang=c :
     * #define INT_LEAST32_MIN -2147483648
     * }
     */
    public static int INT_LEAST32_MIN() {
        return INT_LEAST32_MIN;
    }
    private static final int INT_LEAST32_MAX = (int)2147483647L;
    /**
     * {@snippet lang=c :
     * #define INT_LEAST32_MAX 2147483647
     * }
     */
    public static int INT_LEAST32_MAX() {
        return INT_LEAST32_MAX;
    }
    private static final int UINT_LEAST32_MAX = (int)4294967295L;
    /**
     * {@snippet lang=c :
     * #define UINT_LEAST32_MAX 4294967295
     * }
     */
    public static int UINT_LEAST32_MAX() {
        return UINT_LEAST32_MAX;
    }
    private static final int INT_FAST32_MIN = (int)-2147483648L;
    /**
     * {@snippet lang=c :
     * #define INT_FAST32_MIN -2147483648
     * }
     */
    public static int INT_FAST32_MIN() {
        return INT_FAST32_MIN;
    }
    private static final int INT_FAST32_MAX = (int)2147483647L;
    /**
     * {@snippet lang=c :
     * #define INT_FAST32_MAX 2147483647
     * }
     */
    public static int INT_FAST32_MAX() {
        return INT_FAST32_MAX;
    }
    private static final int UINT_FAST32_MAX = (int)4294967295L;
    /**
     * {@snippet lang=c :
     * #define UINT_FAST32_MAX 4294967295
     * }
     */
    public static int UINT_FAST32_MAX() {
        return UINT_FAST32_MAX;
    }
    private static final int INT16_MAX = (int)32767L;
    /**
     * {@snippet lang=c :
     * #define INT16_MAX 32767
     * }
     */
    public static int INT16_MAX() {
        return INT16_MAX;
    }
    private static final int INT16_MIN = (int)-32768L;
    /**
     * {@snippet lang=c :
     * #define INT16_MIN -32768
     * }
     */
    public static int INT16_MIN() {
        return INT16_MIN;
    }
    private static final int UINT16_MAX = (int)65535L;
    /**
     * {@snippet lang=c :
     * #define UINT16_MAX 65535
     * }
     */
    public static int UINT16_MAX() {
        return UINT16_MAX;
    }
    private static final int INT_LEAST16_MIN = (int)-32768L;
    /**
     * {@snippet lang=c :
     * #define INT_LEAST16_MIN -32768
     * }
     */
    public static int INT_LEAST16_MIN() {
        return INT_LEAST16_MIN;
    }
    private static final int INT_LEAST16_MAX = (int)32767L;
    /**
     * {@snippet lang=c :
     * #define INT_LEAST16_MAX 32767
     * }
     */
    public static int INT_LEAST16_MAX() {
        return INT_LEAST16_MAX;
    }
    private static final int UINT_LEAST16_MAX = (int)65535L;
    /**
     * {@snippet lang=c :
     * #define UINT_LEAST16_MAX 65535
     * }
     */
    public static int UINT_LEAST16_MAX() {
        return UINT_LEAST16_MAX;
    }
    private static final int INT_FAST16_MIN = (int)-32768L;
    /**
     * {@snippet lang=c :
     * #define INT_FAST16_MIN -32768
     * }
     */
    public static int INT_FAST16_MIN() {
        return INT_FAST16_MIN;
    }
    private static final int INT_FAST16_MAX = (int)32767L;
    /**
     * {@snippet lang=c :
     * #define INT_FAST16_MAX 32767
     * }
     */
    public static int INT_FAST16_MAX() {
        return INT_FAST16_MAX;
    }
    private static final int UINT_FAST16_MAX = (int)65535L;
    /**
     * {@snippet lang=c :
     * #define UINT_FAST16_MAX 65535
     * }
     */
    public static int UINT_FAST16_MAX() {
        return UINT_FAST16_MAX;
    }
    private static final int INT8_MAX = (int)127L;
    /**
     * {@snippet lang=c :
     * #define INT8_MAX 127
     * }
     */
    public static int INT8_MAX() {
        return INT8_MAX;
    }
    private static final int INT8_MIN = (int)-128L;
    /**
     * {@snippet lang=c :
     * #define INT8_MIN -128
     * }
     */
    public static int INT8_MIN() {
        return INT8_MIN;
    }
    private static final int UINT8_MAX = (int)255L;
    /**
     * {@snippet lang=c :
     * #define UINT8_MAX 255
     * }
     */
    public static int UINT8_MAX() {
        return UINT8_MAX;
    }
    private static final int INT_LEAST8_MIN = (int)-128L;
    /**
     * {@snippet lang=c :
     * #define INT_LEAST8_MIN -128
     * }
     */
    public static int INT_LEAST8_MIN() {
        return INT_LEAST8_MIN;
    }
    private static final int INT_LEAST8_MAX = (int)127L;
    /**
     * {@snippet lang=c :
     * #define INT_LEAST8_MAX 127
     * }
     */
    public static int INT_LEAST8_MAX() {
        return INT_LEAST8_MAX;
    }
    private static final int UINT_LEAST8_MAX = (int)255L;
    /**
     * {@snippet lang=c :
     * #define UINT_LEAST8_MAX 255
     * }
     */
    public static int UINT_LEAST8_MAX() {
        return UINT_LEAST8_MAX;
    }
    private static final int INT_FAST8_MIN = (int)-128L;
    /**
     * {@snippet lang=c :
     * #define INT_FAST8_MIN -128
     * }
     */
    public static int INT_FAST8_MIN() {
        return INT_FAST8_MIN;
    }
    private static final int INT_FAST8_MAX = (int)127L;
    /**
     * {@snippet lang=c :
     * #define INT_FAST8_MAX 127
     * }
     */
    public static int INT_FAST8_MAX() {
        return INT_FAST8_MAX;
    }
    private static final int UINT_FAST8_MAX = (int)255L;
    /**
     * {@snippet lang=c :
     * #define UINT_FAST8_MAX 255
     * }
     */
    public static int UINT_FAST8_MAX() {
        return UINT_FAST8_MAX;
    }
    private static final long INTPTR_MIN = -9223372036854775808L;
    /**
     * {@snippet lang=c :
     * #define INTPTR_MIN -9223372036854775808
     * }
     */
    public static long INTPTR_MIN() {
        return INTPTR_MIN;
    }
    private static final long INTPTR_MAX = 9223372036854775807L;
    /**
     * {@snippet lang=c :
     * #define INTPTR_MAX 9223372036854775807
     * }
     */
    public static long INTPTR_MAX() {
        return INTPTR_MAX;
    }
    private static final long UINTPTR_MAX = -1L;
    /**
     * {@snippet lang=c :
     * #define UINTPTR_MAX -1
     * }
     */
    public static long UINTPTR_MAX() {
        return UINTPTR_MAX;
    }
    private static final long PTRDIFF_MIN = -9223372036854775808L;
    /**
     * {@snippet lang=c :
     * #define PTRDIFF_MIN -9223372036854775808
     * }
     */
    public static long PTRDIFF_MIN() {
        return PTRDIFF_MIN;
    }
    private static final long PTRDIFF_MAX = 9223372036854775807L;
    /**
     * {@snippet lang=c :
     * #define PTRDIFF_MAX 9223372036854775807
     * }
     */
    public static long PTRDIFF_MAX() {
        return PTRDIFF_MAX;
    }
    private static final long SIZE_MAX = -1L;
    /**
     * {@snippet lang=c :
     * #define SIZE_MAX -1
     * }
     */
    public static long SIZE_MAX() {
        return SIZE_MAX;
    }
    private static final long INTMAX_MIN = -9223372036854775808L;
    /**
     * {@snippet lang=c :
     * #define INTMAX_MIN -9223372036854775808
     * }
     */
    public static long INTMAX_MIN() {
        return INTMAX_MIN;
    }
    private static final long INTMAX_MAX = 9223372036854775807L;
    /**
     * {@snippet lang=c :
     * #define INTMAX_MAX 9223372036854775807
     * }
     */
    public static long INTMAX_MAX() {
        return INTMAX_MAX;
    }
    private static final long UINTMAX_MAX = -1L;
    /**
     * {@snippet lang=c :
     * #define UINTMAX_MAX -1
     * }
     */
    public static long UINTMAX_MAX() {
        return UINTMAX_MAX;
    }
    private static final int SIG_ATOMIC_MIN = (int)-2147483648L;
    /**
     * {@snippet lang=c :
     * #define SIG_ATOMIC_MIN -2147483648
     * }
     */
    public static int SIG_ATOMIC_MIN() {
        return SIG_ATOMIC_MIN;
    }
    private static final int SIG_ATOMIC_MAX = (int)2147483647L;
    /**
     * {@snippet lang=c :
     * #define SIG_ATOMIC_MAX 2147483647
     * }
     */
    public static int SIG_ATOMIC_MAX() {
        return SIG_ATOMIC_MAX;
    }
    private static final int WINT_MIN = (int)0L;
    /**
     * {@snippet lang=c :
     * #define WINT_MIN 0
     * }
     */
    public static int WINT_MIN() {
        return WINT_MIN;
    }
    private static final int WINT_MAX = (int)65535L;
    /**
     * {@snippet lang=c :
     * #define WINT_MAX 65535
     * }
     */
    public static int WINT_MAX() {
        return WINT_MAX;
    }
    private static final int WCHAR_MAX = (int)65535L;
    /**
     * {@snippet lang=c :
     * #define WCHAR_MAX 65535
     * }
     */
    public static int WCHAR_MAX() {
        return WCHAR_MAX;
    }
    private static final int WCHAR_MIN = (int)0L;
    /**
     * {@snippet lang=c :
     * #define WCHAR_MIN 0
     * }
     */
    public static int WCHAR_MIN() {
        return WCHAR_MIN;
    }
}

