package org.se.lab.unit;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.data.Article;

public class ArticleTest
{
    @Test
    public void testToString()
    {
        Article a = new Article(7, "DVD", 1599);

        Assert.assertEquals("7,DVD,1599", a.toString());
    }

    @Test
    public void testHashCodeAndEquals()
    {
        Article a1 = new Article(7, "DVD", 1599);
        Article a2 = new Article(7, "DVD", 1599);

        Assert.assertTrue(a1.hashCode() == a2.hashCode());
        Assert.assertTrue(a1.equals(a2));
        Assert.assertTrue(a2.equals(a1));
    }
}
