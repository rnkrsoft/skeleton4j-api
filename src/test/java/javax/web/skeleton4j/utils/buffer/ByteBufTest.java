package javax.web.skeleton4j.utils.buffer;

import org.junit.Assert;
import org.junit.Test;

import javax.web.skeleton4j.buffer.ByteBuf;
import java.math.BigDecimal;

/**
 * Created by devops4j on 2017/11/30.
 */
public class ByteBufTest {

    @Test
    public void testCapacity() throws Exception {
        ByteBuf byteBuf = ByteBuf.allocate(1);
        Assert.assertEquals(0, byteBuf.readableLength());
        Assert.assertEquals(1, byteBuf.writableLength());
        byteBuf.put((byte) (8));
        Assert.assertEquals(1, byteBuf.readableLength());
        Assert.assertEquals(0, byteBuf.writableLength());
        Assert.assertEquals((byte) (8), byteBuf.getByte());
        byteBuf.clear();
        Assert.assertEquals(0, byteBuf.readableLength());
        Assert.assertEquals(1, byteBuf.writableLength());
        byteBuf.put((byte) (9));
        Assert.assertEquals(1, byteBuf.readableLength());
        Assert.assertEquals(0, byteBuf.writableLength());
        Assert.assertEquals((byte) (9), byteBuf.getByte());
        try {
            byteBuf.put((byte) (11));
            Assert.fail();
        } catch (Exception e) {
            Assert.assertEquals(0, byteBuf.readableLength());
            Assert.assertEquals(0, byteBuf.writableLength());
        }
        byteBuf.setAutoExpand(true);
        byteBuf.put((byte) (11));
        Assert.assertEquals(2, byteBuf.capacity());
    }

    @Test
    public void testCapacity1() throws Exception {
        ByteBuf byteBuf = ByteBuf.allocate(2);
        Assert.assertEquals(0, byteBuf.readableLength());
        Assert.assertEquals(2, byteBuf.writableLength());
        byteBuf.put((byte) (8));
        Assert.assertEquals(1, byteBuf.readableLength());
        Assert.assertEquals(1, byteBuf.writableLength());
        byteBuf.put((byte) (11));
        Assert.assertEquals(2, byteBuf.readableLength());
        Assert.assertEquals(0, byteBuf.writableLength());
        Assert.assertEquals((byte) (8), byteBuf.getByte());
        Assert.assertEquals((byte) (11), byteBuf.getByte());
        try {
            byteBuf.put((byte) (112));
            Assert.fail();
        } catch (Exception e) {

        }
        byteBuf.setAutoExpand(true);
        byteBuf.put((byte) (112));
        Assert.assertEquals(4, byteBuf.capacity());
    }

    @Test
    public void testAllocate() throws Exception {
        byte[] data = new byte[]{(byte) (1), (byte) (2), (byte) (3)};
        ByteBuf byteBuf = ByteBuf.allocate(data);
        Assert.assertEquals((byte) (1), byteBuf.getByte());
        Assert.assertEquals((byte) (2), byteBuf.getByte());
        Assert.assertEquals((byte) (3), byteBuf.getByte());
    }

    @Test
    public void testCapacity2() throws Exception {
        ByteBuf byteBuf = ByteBuf.allocate(8);
        byteBuf.put(123456789L);
        Assert.assertEquals(123456789L, byteBuf.getLong());
    }

    @Test
    public void testCapacity3() throws Exception {
        ByteBuf byteBuf = ByteBuf.allocate(16);
        byteBuf.put(123456);
        byteBuf.put(6789);
        Assert.assertEquals(123456, byteBuf.getInt());
        Assert.assertEquals(6789, byteBuf.getInt());
        Assert.assertEquals(8, byteBuf.writableLength());
        Assert.assertEquals(0, byteBuf.readableLength());
        byteBuf.clear();
        byteBuf.put(321456D);
        byteBuf.put(123456D);
        Assert.assertEquals("321456", new BigDecimal(byteBuf.getDouble()).toString());
        Assert.assertEquals("123456", new BigDecimal(byteBuf.getDouble()).toString());
        Assert.assertEquals(0, byteBuf.writableLength());
        Assert.assertEquals(0, byteBuf.readableLength());
        byteBuf.clear();
        byteBuf.put(321456F);
        byteBuf.put(123456F);
        byteBuf.put(123457F);
        byteBuf.put(123458F);
        Assert.assertEquals("321456", new BigDecimal(byteBuf.getFloat()).toString());
        Assert.assertEquals("123456", new BigDecimal(byteBuf.getFloat()).toString());
        Assert.assertEquals("123457", new BigDecimal(byteBuf.getFloat()).toString());
        Assert.assertEquals("123458", new BigDecimal(byteBuf.getFloat()).toString());
        Assert.assertEquals(0, byteBuf.writableLength());
        Assert.assertEquals(0, byteBuf.readableLength());
    }

    @Test
    public void testMaxCapacity() throws Exception {
        ByteBuf byteBuf = ByteBuf.allocate(1024);
        byteBuf.put("UTF-8", "this is a test");
        String str = byteBuf.getString("UTF-8", byteBuf.readableLength());
        Assert.assertEquals("this is a test", str);
        byteBuf.put("UTF-8", "this is a test");
        String str1 = byteBuf.getString("UTF-8", byteBuf.readableLength());
        Assert.assertEquals("this is a test", str1);
    }

    @Test
    public void testIsAutoExpand() throws Exception {
        ByteBuf buf = ByteBuf.allocate(50 * 1024 * 1024);
        for (int i = 0; i < 100; i++) {
            buf.put(i);
        }
        while (buf.readableLength() > 0) {
            System.out.println(buf.getInt());
        }
    }

    @Test
    public void testSetAutoExpand() throws Exception {

    }

    @Test
    public void testIsReadOnly() throws Exception {

    }

    @Test
    public void testSetReadOnly() throws Exception {

    }

    @Test
    public void testClear() throws Exception {

    }

    @Test
    public void testPut() throws Exception {

    }

    @Test
    public void testPut1() throws Exception {

    }

    @Test
    public void testPut2() throws Exception {

    }

    @Test
    public void testPut3() throws Exception {

    }

    @Test
    public void testPut4() throws Exception {

    }

    @Test
    public void testPut5() throws Exception {

    }

    @Test
    public void testPut6() throws Exception {

    }

    @Test
    public void testPut7() throws Exception {

    }

    @Test
    public void testPut8() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testGetByteBuffer() throws Exception {

    }

    @Test
    public void testGet1() throws Exception {

    }

    @Test
    public void testGetString() throws Exception {

    }

    @Test
    public void testGetByte() throws Exception {

    }

    @Test
    public void testGetShort() throws Exception {

    }

    @Test
    public void testGetInt() throws Exception {

    }

    @Test
    public void testGetLong() throws Exception {

    }

    @Test
    public void testGetFloat() throws Exception {

    }

    @Test
    public void testGetDouble() throws Exception {

    }

    @Test
    public void testGetBytes() throws Exception {

    }

    @Test
    public void testGetBytes1() throws Exception {

    }

    @Test
    public void testReadableLength() throws Exception {

    }

    @Test
    public void testWritableLength() throws Exception {

    }

    @Test
    public void testAllocate1() throws Exception {

    }

    @Test
    public void testAllocate2() throws Exception {

    }
}