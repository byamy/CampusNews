package com.campus.events;

import com.campus.model.User;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyles;

public class Academic extends Events {

    public Academic(HtmlStyles title, String description, String date, String time, String location, User creator) {
        super(title, description, date, time, location, creator);
    }

    @Override
    public String getEventType() {
        return "Academic";
    }
}
