package com.webex.dataservice.dao.givr.rdbms;

import com.webex.dataservice.dao.SqlBaseDao;
import com.webex.dataservice.service.dos.MaccdomainDO;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiujguo on 14-7-11.
 */
public class GlobalivrRdbmsDao extends SqlBaseDao implements IGlobalivrRdbmsDao {
    @Override
    public Map<Integer, MaccdomainDO> selectMaccIndexByAccessCode(String accessCode) {
        final Map<Integer, MaccdomainDO> map=new HashMap<Integer, MaccdomainDO>();
        getSqlSession().select("selectMaccIndexByAccessCode", accessCode, new ResultHandler() {
            @Override
            public void handleResult(ResultContext context) {
                MaccdomainDO o= (MaccdomainDO) context.getResultObject();
                map.put(o.getPriority(),o);
            }
        });
       return map;
    }
}
