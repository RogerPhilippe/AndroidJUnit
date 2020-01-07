package br.com.philippesis.androidjunit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.philippesis.androidjunit.db.DatabaseHandlerTest;
import br.com.philippesis.androidjunit.db.MessageDAOTest;
import br.com.philippesis.androidjunit.db.MessageTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({DatabaseHandlerTest.class, MessageDAOTest.class, MessageTest.class,
        BuildConfigTest.class})
public class TestSuite { }
