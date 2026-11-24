import com.saurabhsvision.sbrowser.UrlTools;
import com.saurabhsvision.sbrowser.AddressResolver;
import java.net.URLDecoder;
public final class Utf8QueryTest {
    public static void main(String[] args) throws Exception {
        String[] inputs={"छत्तीसगढ़ समाचार", "physics + maths & science", "भारत 🌏", "a/b?c=d#e", ""};
        for(String input:inputs){
            String encoded=UrlTools.encodeQuery(input);
            if(!input.equals(URLDecoder.decode(encoded,"UTF-8")))throw new AssertionError("UTF-8 round trip");
        }
        String q=AddressResolver.resolve("छत्तीसगढ़ समाचार","google");
        if(!q.endsWith(UrlTools.encodeQuery(inputs[0])))throw new AssertionError("Hindi search encoding");
        System.out.println("PASS UTF-8 search encoding");
    }
}
