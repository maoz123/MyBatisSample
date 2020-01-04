package demo.interceptors;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

@Intercepts({@Signature(type= StatementHandler.class, method = "parameterize",
        args = {java.sql.Statement.class})})
public class PramInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("interceptor execution" + " ： " + invocation.getMethod());
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        System.out.println(target);
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        System.out.println(properties);
    }
}
