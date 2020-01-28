package com.webtrekk.challenge.emailApi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailDTO {

    @NotNull(message = "email can not be null!")
    public String to_email;

    @NotNull(message = "Subject can not be null!")
    public String subject;

    public String textContext;

    public String attachmentType;

    public String pathToAttachment;

    public String getTo_email() {
        return to_email;
    }

    public void setTo_email(String to_email) {
        this.to_email = to_email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTextContext() {
        return textContext;
    }

    public void setTextContext(String textContext) {
        this.textContext = textContext;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public String getPathToAttachment() {
        return pathToAttachment;
    }

    public void setPathToAttachment(String pathToAttachment) {
        this.pathToAttachment = pathToAttachment;
    }
}
