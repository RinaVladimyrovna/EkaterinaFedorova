package hws.hw8.resourceFilesReference;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FilesReference {

    INPUT_METALS_COLORS_DATA_SET("src/test/resources/hws/hw8/inputJsonFile.json");

    String fileAddress;

    @Override
    public String toString() {
        return fileAddress;
    }
}
