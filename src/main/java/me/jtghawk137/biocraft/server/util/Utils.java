package me.jtghawk137.biocraft.server.util;

import java.util.Locale;

public class Utils
{

    public static String formatString(String string)
    {
        return string.toLowerCase(Locale.ENGLISH).replaceAll(" ", "_").replaceAll("'", "");
    }
}
