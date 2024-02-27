package com.sibghat.vape_shop_authorization_server.mappers;

import java.util.function.Consumer;

public interface ConsumerMapper<A>  {

    void addToSet(A setToAppend);
    Consumer<A> map();

}
