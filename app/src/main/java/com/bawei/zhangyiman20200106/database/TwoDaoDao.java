package com.bawei.zhangyiman20200106.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bawei.zhangyiman20200106.model.dao.TwoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TWO_DAO".
*/
public class TwoDaoDao extends AbstractDao<TwoDao, Void> {

    public static final String TABLENAME = "TWO_DAO";

    /**
     * Properties of entity TwoDao.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Type = new Property(0, String.class, "type", false, "TYPE");
    }


    public TwoDaoDao(DaoConfig config) {
        super(config);
    }
    
    public TwoDaoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TWO_DAO\" (" + //
                "\"TYPE\" TEXT);"); // 0: type
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TWO_DAO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TwoDao entity) {
        stmt.clearBindings();
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(1, type);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TwoDao entity) {
        stmt.clearBindings();
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(1, type);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public TwoDao readEntity(Cursor cursor, int offset) {
        TwoDao entity = new TwoDao( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0) // type
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TwoDao entity, int offset) {
        entity.setType(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(TwoDao entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(TwoDao entity) {
        return null;
    }

    @Override
    public boolean hasKey(TwoDao entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}