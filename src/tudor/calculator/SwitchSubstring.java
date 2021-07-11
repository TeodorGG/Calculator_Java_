package tudor.calculator;

public class SwitchSubstring {
    private static final SwitchSubstring DONE = new SwitchSubstring(null) {
        @Override
        public SwitchSubstring when(String subString, Runnable r) {
            return this;
        }

        @Override
        public void orElse(Runnable r) {
        }
    };

    private final String str;

    private SwitchSubstring(String str) {
        this.str = str;
    }

    public SwitchSubstring when(String subString, Runnable r) {
        if(str.contains(subString)) {
            r.run();
            return DONE;
        }
        return this;
    }

    public void orElse(Runnable r) {
        r.run();
    }

    public static SwitchSubstring of(String str) {
        return new SwitchSubstring(str);
    }

}
