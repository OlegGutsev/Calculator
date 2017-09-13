package by.bstu.fit.oleggutsev.lab2and3android;

import java.util.Dictionary;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

enum Binary {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE
}

enum Unary{

}

public class Operations {
    public Map<Binary,String> mDictionaryBinary =
            new EnumMap<Binary, String>(Binary.class);
    private Binary mBinary;

    public Operations(){
        mDictionaryBinary.put(Binary.PLUS, "+");
        mDictionaryBinary.put(Binary.MINUS, "-");
        mDictionaryBinary.put(Binary.DIVIDE, "/");
        mDictionaryBinary.put(Binary.MULTIPLY, "*");
    }

    private float Plus(String number)
    {
        return Float.parseFloat(number);
    }

}
