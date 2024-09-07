import json

with open('scan-results.json') as f:
    data = json.load(f)
    for vuln in data['vulnerabilities']:
        print(f"ID: {vuln['id']}, Severity: {vuln['severity']}, Description: {vuln['description']}")
