import com.saurabhsvision.sbrowser.AddressResolver;
public final class SecureAddressTest {
    private static void ok(boolean pass){if(!pass)throw new AssertionError("Address regression");}
    public static void main(String[] args){
        ok("https://example.org/path".equals(AddressResolver.resolve("http://example.org/path","google")));
        ok("https://example.org?q=test".equals(AddressResolver.resolve("example.org?q=test","google")));
        ok(AddressResolver.resolve("https://","google")==null);
        ok(AddressResolver.resolve("https://example.org@evil.org","google")==null);
        ok(AddressResolver.resolve("https://example.org:99999","google")==null);
        ok(AddressResolver.resolve("mailto:someone@example.org","google")==null);
        ok(AddressResolver.resolve("https://example.org:","google")==null);
        ok(AddressResolver.resolve("physics chapter 2","google").contains("physics+chapter+2"));
        System.out.println("PASS secure URL validation");
    }
}
