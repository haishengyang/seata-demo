package com.distribution.transaction.storage.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.distribution.transaction.storage.mapper.StorageMapper;
import com.distribution.transaction.storage.po.Storage;
import com.distribution.transaction.storage.service.StorageService;
import io.seata.core.context.RootContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {

    private final StorageMapper storageMapper;

    @Override
    public void deduct(String commodityCode, int count) {
        log.info("Stock Service Begin ... xid: " + RootContext.getXID());
        log.info("Deducting inventory SQL: update stock_tbl set count = count - {} where commodity_code = {}", count,
                commodityCode);

        Storage storage = storageMapper.selectOne(Wrappers.<Storage>lambdaQuery().eq(Storage::getCommodityCode, commodityCode));
        storage.setCount(storage.getCount() - count);
        storageMapper.updateById(storage);
        log.info("Stock Service End ... ");
    }
}
