package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Lecturer
{
	/*
	 * Constructor
	 */
	public Lecturer(long id, String firstName, String lastName, String email)
	{
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
	}


	/*
	 * Property: id
	 */
	private long id;
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		if(id < 0)
			throw new IllegalArgumentException();
		this.id = id;
	}

    /*
     * Property: firstName
     */
    private String firstName;
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        if(firstName == null)
            throw new IllegalArgumentException();
        this.firstName = firstName;
    }



    /*
     * Property: lastName
     */
    private String lastName;
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        if(lastName == null)
            throw new IllegalArgumentException();
        this.lastName = lastName;
    }



    /*
     * Property: email
     */
    private String email;
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        // email can be null!! [0-1]
        this.email = email;
    }


    /*
     * Association: ---[*]-> courses:Course
     */
    private List<Course> courses = new ArrayList<Course>();
    public void addCourse(Course course)
    {
        if(course == null)
            throw new IllegalArgumentException();
        courses.add(course);
    }
    public List<Course> getCourses()
    {
        return courses;
    }


    /*
     * Object methods
     */

    public String toString()
    {
        return getId() + "," + getFirstName() + "," + getLastName() + "," + getEmail();
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecturer lecturer = (Lecturer) o;

        return id == lecturer.id;
    }

    @Override
    public int hashCode()
    {
        return (int) (id ^ (id >>> 32));
    }
}
