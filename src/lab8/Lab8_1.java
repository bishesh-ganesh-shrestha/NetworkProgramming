package lab8;

import java.nio.IntBuffer;

public class Lab8_1 {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        for(int i = 0; i<10; i++){
            intBuffer.put(i+1);
        }
        int[] array = intBuffer.array();
        IntBuffer intBuffer2 = IntBuffer.wrap(array);
        intBuffer.rewind();
        intBuffer2.rewind();
        System.out.println(intBuffer.equals(intBuffer2));        
    }
}
