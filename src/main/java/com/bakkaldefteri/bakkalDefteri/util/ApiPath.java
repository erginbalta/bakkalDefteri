package com.bakkaldefteri.bakkalDefteri.util;

public class ApiPath {
    private static final String BASE_PATH="/api";
    public static final class SuppliersCTRL{
        public static final String CTRL = BASE_PATH +"/suppliers";
    }
    public static final class CustomersCTRL{
        public static final String CTRL = BASE_PATH +"/customers";
    }
    public static final class StockCardCTRL{
        public static final String CTRL = BASE_PATH +"/stockCard";
    }
    public static final class ProductCardCTRL{
        public static final String CTRL = BASE_PATH +"/productCard";
    }
    public static final class CategoriesCTRL{
        public static final String CTRL = BASE_PATH +"/categories";
    }
    public static final class IncomingInvoiceCTRL{
        public static final String CTRL = BASE_PATH +"/incomingInvoices";
    }
    public static final class OutgoingInvoiceCTRL{
        public static final String CTRL = BASE_PATH +"/outgoingInvoices";
    }
    public static final class UserCTRL{
        public static final String CTRL = BASE_PATH +"/user";
    }
}
