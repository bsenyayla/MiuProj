package com.eregistrar.miueregistrar.service;

import com.eregistrar.miueregistrar.model.Block;

import java.util.List;

public interface BlockService {

    public abstract Block saveBlock(Block block);
    public abstract List<Block> getAllBlocks();
    public abstract Block getBlockById(int id);
}
