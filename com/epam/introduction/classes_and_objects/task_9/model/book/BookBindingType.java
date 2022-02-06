package com.epam.introduction.classes_and_objects.task_9.model.book;

public enum BookBindingType {
    SADDLE_STITCH("saddle stitch"),
    PUR("PUR"),
    HARDCOVER("hardcover"),
    SINGER_SEWN("singer sewn"),
    SECTION_SEWN("section sewn"),
    COPTIC_STITCH("soptic stitch"),
    SPIRAL("spiral"),
    INTERSCREW("interscrew"),
    JAPANESE("japanese"),
    SLIPCASES("slipcases");

    private final String TYPE;

    BookBindingType(String type) {
        TYPE = type;
    }

    public String getType() {
        return TYPE;
    }
}