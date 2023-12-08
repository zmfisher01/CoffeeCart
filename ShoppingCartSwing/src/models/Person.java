package models;

public class Person {

    private String username;
    private String hashedPassword;
    private boolean isSeller;

    public Person(String details) {
        decipherSentence(details);
    }

    public Person(String username, String hashedPassword, boolean isSeller) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.isSeller = isSeller;
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public boolean isSeller() {
        return isSeller;
    }

    @Override
    public String toString() {
        return String.format("Username: %s, Is Seller: %s", username, isSeller);
    }

    public String toSavableString() {
        return String.format("%s·%s·%s", username, hashedPassword, isSeller);
    }

    
    public static Person decipherSentence(String sentence) {
        String[] parts = sentence.split("");

        if (parts.length == 3) {
            try {
                String username = parts[0];
                String hashedPassword = parts[1];
                boolean isSeller = Boolean.parseBoolean(parts[2]);

                return new Person(username, hashedPassword, isSeller);
            } catch (NumberFormatException e) {
                System.err.println("Error parsing values in the sentence.");
            }
        } else {
            System.err.println("Invalid number of parts in the sentence.");
        }

        return null;
    }

}
