/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE614_Sensitive_Cookie_Without_Secure__Servlet_02.java
Label Definition File: CWE614_Sensitive_Cookie_Without_Secure__Servlet.label.xml
Template File: point-flaw-02.tmpl.java
*/
/*
* @description
* CWE: 614 Sensitive Cookie Without Secure
* Sinks:
*    GoodSink: secure flag set
*    BadSink : secure flag not set
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */

package testcases.CWE614_Sensitive_Cookie_Without_Secure;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE614_Sensitive_Cookie_Without_Secure__Servlet_02 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (true)
        {
            Cookie c = new Cookie("SecretMessage", "test");
            if( request.isSecure() )
            {
                response.addCookie(c); /* FLAW: secure flag not set */
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Cookie c = new Cookie("SecretMessage", "Drink your Ovaltine");
            if( request.isSecure() )
            {
                c.setSecure(true); /* FIX: adds "secure" flag/attribute to cookie */
                response.addCookie(c);
            }

        }
    }

    /* good1() changes true to false */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(false)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Cookie c = new Cookie("SecretMessage", "test");
            if( request.isSecure() )
            {
                response.addCookie(c); /* FLAW: secure flag not set */
            }
        }
        else {

            Cookie c = new Cookie("SecretMessage", "Drink your Ovaltine");
            if( request.isSecure() )
            {
                c.setSecure(true); /* FIX: adds "secure" flag/attribute to cookie */
                response.addCookie(c);
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(true)
        {
            Cookie c = new Cookie("SecretMessage", "Drink your Ovaltine");
            if( request.isSecure() )
            {
                c.setSecure(true); /* FIX: adds "secure" flag/attribute to cookie */
                response.addCookie(c);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Cookie c = new Cookie("SecretMessage", "test");
            if( request.isSecure() )
            {
                response.addCookie(c); /* FLAW: secure flag not set */
            }

        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
        good2(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
