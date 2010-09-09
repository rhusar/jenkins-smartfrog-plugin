job = hudson.model.Hudson.instance.getItem("eap-51x-stress-orderdemo-single")
hudson.XmlFile cfg = job.getConfigFile();
if(cfg.exists()) {
   cfg.unmarshal(job);
}
job.onLoad(job.getParent(), job.getRootDir().getName())