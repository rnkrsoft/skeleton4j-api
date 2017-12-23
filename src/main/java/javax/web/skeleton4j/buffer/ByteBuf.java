package javax.web.skeleton4j.buffer;

import java.nio.ByteBuffer;

/**
 * Created by devops4j on 2017/11/30.
 */
public abstract class ByteBuf {
    public static ByteBuf allocate(int capacity) {
        return new HeapByteBuf(capacity);
    }

    public static ByteBuf allocate(byte[] data) {
        return new HeapByteBuf(data);
    }

    public abstract boolean bigEndian();

    public abstract ByteBuf bigEndian(boolean bigEndian);

    public abstract int capacity();

    public abstract ByteBuf capacity(int newCapacity);

    public abstract int maxCapacity();

    public abstract boolean isAutoExpand();

    public abstract ByteBuf setAutoExpand(boolean autoExpand);

    public abstract boolean isReadOnly();

    public abstract ByteBuf setReadOnly(boolean readOnly);

    public abstract ByteBuf clear();

    public abstract ByteBuf put(byte v);

    public abstract ByteBuf put(short v);

    public abstract ByteBuf put(int v);

    public abstract ByteBuf put(long v);

    public abstract ByteBuf put(float v);

    public abstract ByteBuf put(double v);

    public abstract ByteBuf put(byte[] v);

    public abstract ByteBuf put(String charset, String... strings);

    public abstract ByteBuf put(ByteBuffer buffer);

    public abstract ByteBuf get(byte[] data);

    public abstract ByteBuffer asByteBuffer();

    public abstract ByteBuf get(ByteBuffer buffer);

    public abstract String getString(String charset, int length);

    public abstract byte getByte();

    public abstract short getShort();

    public abstract int getInt();

    public abstract long getLong();

    public abstract float getFloat();

    public abstract double getDouble();

    public abstract byte[] getBytes();

    public abstract byte[] getBytes(int length);

    public abstract int readableLength();

    public abstract int writableLength();
}
