package com.objecteffects.jsftest.view;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

/**
 */
@Named
@SessionScoped
public class BackingBean1 implements Serializable {
    private static final long serialVersionUID = 1L;

    private final static Logger log =
            LoggerFactory.getLogger(BackingBean1.class.getSimpleName());

    private String something1, something2;

    private String user;
    private Boolean hide;
    private String upOrDown;
    private Integer count;

    private final List<String> userNames =
            List.of("user1", "user2", "user3");

    /**
     * @return the something1
     */
    public String getSomething1() {
        log.info("get something1: {}", this.something1);

        return this.something1;
    }

    /**
     * @param _something1 the something1 to set
     */
    public void setSomething1(final String _something1) {
        log.info("set something1: {}", _something1);

        this.something1 = _something1;
    }

    /**
     * @return the something2
     */
    public String getSomething2() {
        log.info("get something2: {}", this.something2);

        return this.something2;
    }

    /**
     * @param _something2 the something2 to set
     */
    public void setSomething2(final String _something2) {
        log.info("set something2: {}", _something2);

        this.something2 = _something2;
    }

    /**
     * @return List of userNames
     */
    public List<String> getUserNames() {
        return this.userNames;
    }

    /**
     * @param user
     * @param hide
     * @param upOrDown
     * @param count
     * @return String url
     */
    public String submit(final String user, final Boolean hide,
            final String upOrDown, final Integer count) {
        this.user = user;
        this.hide = hide;
        this.upOrDown = upOrDown;
        this.count = count;

        log.info("submit, user: {}, hide: {}, upOrDown: {}, count: {}",
                this.user, this.hide, this.upOrDown, this.count);

        return "page2-submit?faces-redirect=true";
    }

    /**
     */
    public void dumpParams() {
        final Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();

        log.info("params: {}", params);
    }
}
