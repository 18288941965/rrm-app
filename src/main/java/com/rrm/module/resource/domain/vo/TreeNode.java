package com.rrm.module.resource.domain.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资源包名构建为树.
 *
 * @author TWL 2024/9/24 10:32
 * @since 1.0
 */
@Data
public class TreeNode {
    private String name;
    private List<TreeNode> children = new ArrayList<>();

    // 无参构造函数
    public TreeNode() {
    }

    // 有参构造函数
    public TreeNode(String name) {
        this.name = name;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    // 将 List<String> 转换为符合 el-tree 的数据结构
    public List<TreeNode> buildTree(List<String> controllers) {
        Map<String, TreeNode> nodeMap = new HashMap<>();
        List<TreeNode> rootNodes = new ArrayList<>();

        for (String controller : controllers) {
            String[] parts = controller.split("\\.");
            TreeNode currentNode = null;

            int flag = 0;
            for (String part : parts) {
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i <= flag; i++) {
                    temp.append(parts[i]);
                    if (i != flag) {
                        temp.append(".");
                    }
                }
                String fullPath = String.join(".", temp.toString(), part);
                flag++;

                if (!nodeMap.containsKey(fullPath)) {
                    TreeNode newNode = new TreeNode(part);
                    nodeMap.put(fullPath, newNode);
                    if (currentNode == null) {
                        // 如果是根节点
                        rootNodes.add(newNode);
                    } else {
                        currentNode.addChild(newNode);
                    }
                }
                currentNode = nodeMap.get(fullPath);
            }
        }

        return rootNodes;
    }
}
