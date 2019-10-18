package org.se.lab;

import org.junit.Test;
import org.se.lab.data.Article;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArticleTest
{
    @Test
    public void testToString()
    {
        Article a = new Article(1, "Design Patterns", 4295);

        assertEquals("Article{id=1, description='Design Patterns', price=4295}", a.toString());
    }

    @Test
    public void testEqualsAndHashCode()
    {
        Article a1 = new Article(1, "Design Patterns", 4295);
        Article a2 = new Article(1, "Design Patterns, 2nd Edition", 2295);

        assertTrue(a1.equals(a2));
        assertTrue(a1.hashCode() == a2.hashCode());
    }
}
