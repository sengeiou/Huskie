package imooc.naga.server.service;

import imooc.naga.entity.cluster.HdfsSummary;
import imooc.naga.entity.cluster.QueueMetrics;
import imooc.naga.entity.cluster.YarnSummary;
import imooc.naga.repository.cluster.HdfsSummaryRepository;
import imooc.naga.repository.cluster.QueueMetricsRepository;
import imooc.naga.repository.cluster.YarnSummaryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MonitorServiceImpl implements MonitorService {

    @Resource
    HdfsSummaryRepository hdfsSummaryRepository;
    @Resource
    YarnSummaryRepository yarnSummaryRepository;
    @Resource
    QueueMetricsRepository queueMetricsRepository;

    @Override
    public void addHdfsSummary(HdfsSummary hdfsSummary) {
        hdfsSummaryRepository.save(hdfsSummary);
    }

    @Override
    public void addYarnSummary(YarnSummary yarnSummary) {
        yarnSummaryRepository.save(yarnSummary);
    }

    @Override
    public void addQueueMetrics(List<QueueMetrics> queueMetrics) {
        queueMetricsRepository.saveAll(queueMetrics);
    }

    @Override
    public HdfsSummary findHdfsSummary(int selectTime) {
        return hdfsSummaryRepository.findTop1ByIsTrashFalseAndCreateTimeLessThanEqualOrderByCreateTimeDesc(selectTime);
    }

    @Override
    public YarnSummary findYarnSummary(int selectTime) {
        return yarnSummaryRepository.findTop1ByIsTrashFalseAndCreateTimeLessThanEqualOrderByCreateTimeDesc(selectTime);
    }

    @Override
    public List<QueueMetrics> findQueueMetrics(int selectTime) {
        return queueMetricsRepository.findByCreateTime(selectTime);
    }

    @Override
    public List<HdfsSummary> findHdfsSummaryBetween(int startTime, int endTime) {
        return hdfsSummaryRepository.findByIsTrashFalseAndCreateTimeBetweenOrderByCreateTimeAsc(startTime,endTime);
    }

    @Override
    public List<YarnSummary> findYarnSummaryBetween(int startTime, int endTime) {
        return yarnSummaryRepository.findByIsTrashFalseAndCreateTimeBetweenOrderByCreateTimeAsc(startTime,endTime);
    }
}
