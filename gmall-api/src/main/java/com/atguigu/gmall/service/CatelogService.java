package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;

import java.util.List;

public interface CatelogService {
    List<PmsBaseCatalog1> getCatelog1();

    List<PmsBaseCatalog2> getCatelog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatelog3(String catalog2Id);
}
