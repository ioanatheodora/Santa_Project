package elves;

import enums.ElvesType;

public final class ElfFactory {
    private ElfFactory() {

    }

    /**
     * Create an ElfStrategy instance using the Factory Design Pattern
     * @param elfType ElvesType - the type of elf it is created
     * @return ElfStrategy -  an instance of the assigned elf
     */
    public static ElfStrategy createElf(final ElvesType elfType) {
        switch (elfType) {
            case YELLOW: return new YellowElf();
            case WHITE: return new WhiteELf();
            case PINK: return new PinkELf();
            case BLACK: return new BlackELf();
            default:  throw new IllegalArgumentException("The elf does not exist.");
        }
    }
}
