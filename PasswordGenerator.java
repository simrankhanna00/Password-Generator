import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{};:'\",.<>/?`~";

    public static void main(String[] args) {
        int length = 12; // Default password length
        boolean useLower = true;
        boolean useUpper = true;
        boolean useDigits = true;
        boolean useSpecial = true;

        String password = generatePassword(length, useLower, useUpper, useDigits, useSpecial);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, boolean useLower, boolean useUpper, boolean useDigits, boolean useSpecial) {
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be greater than 0");
        }

        StringBuilder password = new StringBuilder(length);
        SecureRandom random = new SecureRandom();

        String allCharacters = "";
        if (useLower) allCharacters += LOWERCASE;
        if (useUpper) allCharacters += UPPERCASE;
        if (useDigits) allCharacters += DIGITS;
        if (useSpecial) allCharacters += SPECIAL_CHARS;

        if (allCharacters.isEmpty()) {
            throw new IllegalArgumentException("At least one character set must be selected");
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(randomIndex));
        }

        return password.toString();
    }
}