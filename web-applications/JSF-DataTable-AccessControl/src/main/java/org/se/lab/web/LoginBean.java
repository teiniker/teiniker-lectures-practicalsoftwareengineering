package org.se.lab.web;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Named
@RequestScoped
public class LoginBean
        implements Serializable
{
    private final Logger LOG = Logger.getLogger(LoginBean.class);
    private static final long serialVersionUID = 1L;

    public LoginBean()
    {
        LOG.info("LoginBean()");
    }

    @PostConstruct
    public void init()
    {
        LOG.info("init()");
    }

    private String username;
    public String getUsername()
    {
        return this.username;
    }
    public void setUsername(String username)
    {
        LOG.info("setUserame(" + username + ")");
        this.username = username;
    }

    private String password;
    public String getPassword()
    {
        return this.password;
    }
    public void setPassword(String password)
    {
        LOG.info("setPassword(" + password + ")");
        this.password = password;
    }

    public String login()
    {
        LOG.info("login()");
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        try
        {
            request.login(this.username, this.password);
        }
        catch (ServletException e)
        {
            context.addMessage(null, new FacesMessage("Login failed."));
            return "error";
        }
        return "index";
    }

    public void logout()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        try
        {
            request.logout();
        }
        catch (ServletException e)
        {
            context.addMessage(null, new FacesMessage("Logout failed."));
        }
    }
}

