package javax.web.skeleton4j.buffer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * Created by devops4j on 2017/11/30.
 */
class HeapByteBuf extends ByteBuf {
    byte[] data = null;
    int writeBegin = 0;
    int writeEnd = 0;
    int readBegin = 0;
    int readEnd = 0;
    boolean readonly = false;
    boolean autoExpand = false;
    boolean bigEndian = false;

    public HeapByteBuf(byte[] data) {
        this.data = data;
        this.writeBegin = 0;
        this.writeEnd = data.length;
        this.readBegin = 0;
        this.readEnd = data.length;
    }

    public HeapByteBuf(int size) {
        this.data = new byte[size];
        this.writeBegin = 0;
        this.writeEnd = data.length;
        this.readBegin = 0;
        this.readEnd = 0;
    }


    @Override
    public boolean bigEndian() {
        return bigEndian;
    }

    @Override
    public ByteBuf bigEndian(boolean bigEndian) {
        this.bigEndian = bigEndian;
        return this;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public ByteBuf capacity(int newCapacity) {
        expendData(newCapacity);
        return this;
    }

    void expendData(int newCapacity) {
        byte[] temp = new byte[newCapacity];
        if (newCapacity > data.length) {
            System.arraycopy(data, 0, temp, 0, data.length);
        } else {
            System.arraycopy(data, 0, temp, 0, newCapacity);
            this.readEnd = newCapacity - 1;
        }
        this.data = temp;
        this.writeEnd = newCapacity - 1;
    }

    @Override
    public int maxCapacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isAutoExpand() {
        return this.autoExpand;
    }

    @Override
    public ByteBuf setAutoExpand(boolean expand) {
        this.autoExpand = expand;
        return this;
    }

    @Override
    public boolean isReadOnly() {
        return readonly;
    }

    @Override
    public ByteBuf setReadOnly(boolean readOnly) {
        this.readonly = readOnly;
        return this;
    }

    @Override
    public ByteBuf clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = 0;
        }
        this.writeBegin = 0;
        this.writeEnd = data.length;
        this.readBegin = 0;
        this.readEnd = 0;
        return this;
    }


    @Override
    public ByteBuf put(byte v) {
        if (writableLength() < 1) {
            if (this.autoExpand) {
                double newCap = Math.round((double) this.data.length * 1.75);
                expendData(Math.max((int) newCap, this.data.length + 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("数组越界");
            }
        }
        this.data[writeBegin] = v;
        writeBegin++;
        readEnd++;
        return this;
    }

    @Override
    public ByteBuf put(short v) {
        if (bigEndian) {
            put(Bits.short1(v));
            put(Bits.short0(v));
        } else {
            put(Bits.short0(v));
            put(Bits.short1(v));
        }
        return this;
    }

    @Override
    public ByteBuf put(int v) {
        if (bigEndian) {
            put(Bits.int3(v));
            put(Bits.int2(v));
            put(Bits.int1(v));
            put(Bits.int0(v));
        } else {
            put(Bits.int0(v));
            put(Bits.int1(v));
            put(Bits.int2(v));
            put(Bits.int3(v));
        }
        return this;
    }

    @Override
    public ByteBuf put(long v) {

        if (bigEndian) {
            put(Bits.long7(v));
            put(Bits.long6(v));
            put(Bits.long5(v));
            put(Bits.long4(v));
            put(Bits.long3(v));
            put(Bits.long2(v));
            put(Bits.long1(v));
            put(Bits.long0(v));
        } else {
            put(Bits.long0(v));
            put(Bits.long1(v));
            put(Bits.long2(v));
            put(Bits.long3(v));
            put(Bits.long4(v));
            put(Bits.long5(v));
            put(Bits.long6(v));
            put(Bits.long7(v));
        }
        return this;
    }

    @Override
    public ByteBuf put(float v) {
        put(Float.floatToRawIntBits(v));
        return this;
    }

    @Override
    public ByteBuf put(double v) {
        put(Double.doubleToRawLongBits(v));
        return this;
    }

    @Override
    public ByteBuf put(byte[] bytes) {
        int length = bytes.length;
        //检测是否越界
        if (writableLength() < length) {
            if (this.autoExpand) {
                int newCap = (int) ((double) this.data.length * 1.75);
                expendData(Math.max(newCap, this.data.length + length));
            } else {
                throw new ArrayIndexOutOfBoundsException("数组越界");
            }
        }
        System.arraycopy(bytes, 0, this.data, this.writeBegin, length);
        //重新计算指针
        this.writeBegin += length;
        this.readEnd += length;
        return this;
    }

    @Override
    public ByteBuf put(String charset, String... strings) {
        for (String str : strings) {
            try {
                byte[] temp = str.getBytes(charset);
                put(temp);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return this;
    }

    @Override
    public ByteBuf put(ByteBuffer buffer) {
        return this;
    }

    @Override
    public byte[] getBytes() {
        return this.data;
    }

    @Override
    public byte[] getBytes(int length) {
        byte[] temp = new byte[length];
        get(temp);
        return temp;
    }

    @Override
    public ByteBuf get(byte[] data) {
        if (data == null) {
            throw new NullPointerException("data is null");
        }
        int length = data.length;
        if (readableLength() < length) {
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }
        System.arraycopy(this.data, this.readBegin, data, 0, length);
        this.readBegin += length;
        return this;
    }

    @Override
    public ByteBuffer asByteBuffer() {
        byte[] temp = new byte[readableLength()];
        get(temp);
        return ByteBuffer.wrap(temp);
    }


    public int readableLength() {
        return this.readEnd - this.readBegin;
    }

    @Override
    public int writableLength() {
        return this.writeEnd - this.writeBegin;
    }

    @Override
    public ByteBuf get(ByteBuffer buffer) {
        int length = readableLength();
        if (buffer.remaining() < length) {
            throw new ArrayIndexOutOfBoundsException("空间不足");
        }
        byte[] temp = new byte[length];
        get(temp);
        buffer.put(temp);
        return this;
    }


    @Override
    public String getString(String charset, int length) {
        byte[] temp = new byte[length];
        get(temp);
        String str = null;
        try {
            str = new String(temp, charset);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public byte getByte() {
        if (readableLength() < 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        byte b = this.data[readBegin++];
        return b;
    }

    @Override
    public short getShort() {
        byte[] temp = new byte[2];
        get(temp);
        return bigEndian
                ? Bits.makeShort(temp[0], temp[1])
                : Bits.makeShort(temp[1], temp[0]);
    }

    @Override
    public int getInt() {
        byte[] temp = new byte[4];
        get(temp);
        return bigEndian
                ? Bits.makeInt(temp[0], temp[1], temp[2], temp[3])
                : Bits.makeInt(temp[3], temp[2], temp[1], temp[0]);
    }

    @Override
    public long getLong() {
        byte[] temp = new byte[8];
        get(temp);
        return bigEndian
                ? Bits.makeLong(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7])
                : Bits.makeLong(temp[7], temp[6], temp[5], temp[4], temp[3], temp[2], temp[1], temp[0]);
    }


    @Override
    public float getFloat() {
        int v = getInt();
        return Float.intBitsToFloat(v);
    }

    @Override
    public double getDouble() {
        long v = getLong();
        return Double.longBitsToDouble(v);
    }

}
